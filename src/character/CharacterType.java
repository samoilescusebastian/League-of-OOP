package character;

public enum CharacterType {
    Knight, Pyromancer, Rogue, Wizard;
    public static final CharacterType convertCharToType(final char c) {
        CharacterType type = null;
        switch (c) {
            case 'K':
                type = CharacterType.Knight;
                break;
            case 'P':
                type = CharacterType.Pyromancer;
                break;
            case 'R':
                type = CharacterType.Rogue;
                break;
            case 'W':
                type = CharacterType.Wizard;
                break;
            default:
                type = null;
                break;
        }
        return type;
    }
}
