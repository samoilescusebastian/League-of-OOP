package game;

import angel.Angel;
import angel.AngelType;
import character.GreatWizard;
import location.Cell;
import location.Map;
import location.Point;
import character.Character;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static utils.Constants.ZERO;
import static utils.Constants.XP_AMP;
import static utils.Constants.XP_REF;
import static utils.Constants.ONE;

public final class GameEngine {
    private GameInput gameInput;
    private fileio.FileSystem fs;
    public GameEngine(final GameInput gameInput, final fileio.FileSystem fs) {
        this.gameInput = gameInput;
        this.fs = fs;

    }
    /**
     * main game logic.
     */
 public void startGame() throws IOException {
        Character.setFileSystem(fs);
        Angel.setFileSystem(fs);
        Map map = gameInput.getMap();
        GreatWizard greatWizard = GreatWizard.getInstance();
        List<Character> players = gameInput.getPlayers();
        map.setPlayers(players);
        addObserverToPlayers(players, greatWizard);
        int roundsNumber = gameInput.getRoundsNumber();
        List<Round> rounds = gameInput.getRounds();
        String moves;
        for (int i = ZERO; i < roundsNumber; i++) {
            fs.writeWord("~~ Round " + String.valueOf(i + 1) + " ~~\n");
            applyRoundEffects(players);
            chooseNextStrategies(players);
            moves = rounds.get(i).getMoves();
            List<Cell> cellConflicts = new ArrayList<>();
            for (int j = ZERO; j < players.size(); j++) {
                Character currentPlayer = players.get(j);
                if (currentPlayer.isDead()) {
                    continue;
                }
                map.deletePlayer(currentPlayer);
                currentPlayer.move(moves.charAt(j));
                map.addPlayer(currentPlayer);
            }
            getCellConflicts(cellConflicts, players,  map);
            startBattles(cellConflicts, players);
            summonAngels(rounds.get(i).getAngels(), map, players, greatWizard);
            fs.writeWord("\n");
        }
 }
    /**
     * print players infos at the end of the game.
     */
 public void viewResults() throws IOException {
        fs.writeWord("~~ Results ~~\n");
        List<Character> players = gameInput.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            fs.writeWord(players.get(i).toString());
            fs.writeWord("\n");
        }
 }
 private void applyRoundEffects(final List<Character> players) {
        for (int i = 0; i < players.size(); i++) {
            Character currentPlayer = players.get(i);
            if (currentPlayer.getParalysisLife() >= 0) {
                currentPlayer.decreaseParalysisLife();
            }
            if (currentPlayer.takeDoT()) {
                currentPlayer.markAsDead();
            }
        }
 }
 private void chooseNextStrategies(final List<Character> players) {

     for (Character player : players) {
         if (player.isParalysed() || player.isDead()) {
             continue;
         }
         player.chooseStrategy();
         player.applyStrategy();
     }
 }
 private void getCellConflicts(final List<Cell> cellList, final List<Character> players,
                               final Map map) {
    for (Character player: players) {
        if (player.isDead()) {
            continue;
        }
        Point playerLocation = player.getLocation();
        Cell playerCell = map.getCell(playerLocation.getX(), playerLocation.getY());
        if (playerCell != null && playerCell.isInConflict(players, player)) {
            cellList.add(playerCell);
        }
    }
 }
 private void startBattles(final List<Cell> battles,
                           final List<Character> players) throws IOException {
        for (int i = 0; i < battles.size(); i++) {
            List<Integer> battlePlayers = battles.get(i).getAliveCharacters(players);
            sortPlayers(battlePlayers, players);
            Character firstPlayer = players.get(battlePlayers.get(ZERO));
            Character secondPlayer = players.get(battlePlayers.get(ONE));
            addLocationBonuses(battles.get(i), firstPlayer, secondPlayer);
            firstPlayer.attack(secondPlayer);
            secondPlayer.attack(firstPlayer);
            addExperience(firstPlayer, secondPlayer);
            updateLevels(firstPlayer, secondPlayer);
            resetEffects(firstPlayer, secondPlayer);
        }
 }
 private void summonAngels(final List<Angel> angels, final Map map, final List<Character> players,
                           final GreatWizard greatWizard) throws IOException {
     for (Angel angel : angels) {
         angel.registerObserver(greatWizard);
         angel.setSummonState();
         Point location = angel.getLocation();
         Cell cell = map.getCell(location.getX(), location.getY());
         cell.sortPlayers();
         for (Integer id : cell.getCharacters()) {
             if (!players.get(id).isDead() || angel.getType() == AngelType.Spawner) {
                 angel.visitPlayer(players.get(id));
                 if (players.get(id).getCurrentHp() <= ZERO) {
                     players.get(id).markAsDead();
                     players.get(id).setKilledByAngelState();
                 }
             }
         }
     }
 }
 private void addObserverToPlayers(final List<Character> players, final GreatWizard greatWizard) {
     for (Character player : players) {
         player.registerObserver(greatWizard);
     }
 }
 private void resetEffects(final Character playerA, final Character playerB) {
        playerA.resetAbilities();
        playerA.resetTakenDamage();
        playerB.resetAbilities();
        playerB.resetTakenDamage();

 }
 private void sortPlayers(final List<Integer> battlePlayers, final List<Character> players) {
        if (players.get(battlePlayers.get(ZERO)).getType() == 'W') {
            Collections.swap(battlePlayers, ONE, ZERO);
        }

 }
 private void addLocationBonuses(final Cell cell, final Character playerA,
                                 final Character playerB) {
        cell.sendBonus(playerA);
        cell.sendBonus(playerB);
 }
 private void updateLevels(final Character playerA, final Character playerB) throws IOException {
        playerA.updateLevel();
        playerB.updateLevel();
 }
 private void addExperience(final Character playerA, final Character playerB) {
     if (playerB.isDead() && !playerA.isDead()) {
         int experience = Math.max(0, XP_REF - (playerA.getLevel() - playerB.getLevel()) * XP_AMP);
         playerA.addExperience(experience);
     }
     if (playerA.isDead() && !playerB.isDead()) {
         int experience = Math.max(0, XP_REF - (playerB.getLevel() - playerA.getLevel()) * XP_AMP);
         playerB.addExperience(experience);
     }

 }
}
