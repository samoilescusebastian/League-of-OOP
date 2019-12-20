package game;

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

public class GameEngine {
    private GameInput gameInput;
    private  fileio.FileSystem fs;
    public GameEngine(final GameInput gameInput, final fileio.FileSystem fs) {
        this.gameInput = gameInput;
        this.fs = fs;

    }
    /**
     * main game logic.
     */
 public void startGame() throws IOException {

        Map map = gameInput.getMap();
        List<Character> players = gameInput.getPlayers();
        map.setPlayers(players);
        int roundsNumber = gameInput.getRoundsNumber();
        List<Round> rounds = gameInput.getRounds();
        String moves;
        for (int i = ZERO; i < roundsNumber; i++) {
            System.out.println(rounds.get(i).getMoves());
            System.out.println(rounds.get(i).getAngels());
            applyRoundEffects(players, map);
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
                Point newLocation = currentPlayer.getLocation();
                Cell cell = map.getCell(newLocation.getX(), newLocation.getY());
                if (cell.isInConflict(currentPlayer)) {
                    cellConflicts.add(cell);
                }
            }
            startBattles(cellConflicts, players, map);
        }
 }
    /**
     * print players infos at the end of the game.
     */
 public void viewResults() throws IOException {
        List<Character> players = gameInput.getPlayers();
        for (int i = 0; i < players.size(); i++) {
            fs.writeWord(players.get(i).toString());
            fs.writeWord("\n");
        }
 }
 private void applyRoundEffects(final List<Character> players, final Map map) {
        for (int i = 0; i < players.size(); i++) {
            Character currentPlayer = players.get(i);
            if (currentPlayer.getParalysisLife() >= 0) {
                currentPlayer.decreaseParalysisLife();
            }
            if (currentPlayer.takeDoT()) {
                currentPlayer.markAsDead(map);
            }
        }
 }
 private void chooseNextStrategies(List<Character> players) {
     for (Character player : players) {
         player.chooseStrategy();
         player.applyStrategy();
     }
 }
 private void startBattles(final List<Cell> battles, final List<Character> players, final Map map) {
        for (int i = 0; i < battles.size(); i++) {
            List<Integer> battlePlayers = battles.get(i).getList();
            sortPlayers(battlePlayers, players);
            Character firstPlayer = players.get(battlePlayers.get(ZERO));
            Character secondPlayer = players.get(battlePlayers.get(ONE));
            addLocationBonuses(battles.get(i), firstPlayer, secondPlayer);
            firstPlayer.attack(secondPlayer);
            secondPlayer.attack(firstPlayer);
            addExperience(firstPlayer, secondPlayer, map);
            updateLevels(firstPlayer, secondPlayer);
            resetEffects(firstPlayer, secondPlayer);
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
 private void updateLevels(final Character playerA, final Character playerB) {
        playerA.updateLevel();
        playerB.updateLevel();
 }
 private void addExperience(final Character playerA, final Character playerB, final Map map) {
     if (playerA.getCurrentHp() <= ZERO) {
        playerA.markAsDead(map);
     }
     if (playerB.getCurrentHp() <= ZERO) {
         playerB.markAsDead(map);
     }
     if (playerA.isDead()) {
         int experience = Math.max(ZERO, XP_REF - (playerB.getLvl() - playerA.getLvl() * XP_AMP));
         playerB.addExperience(experience);
     }
     if (playerB.isDead()) {
         int experience = Math.max(ZERO, XP_REF - (playerA.getLvl() - playerB.getLvl() * XP_AMP));
         playerA.addExperience(experience);
     }

 }
}
