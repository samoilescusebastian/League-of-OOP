package location;

public final class CellFactory {
        private static CellFactory factory = null;
        public static CellFactory getInstance() {
            if (factory == null) {
                factory = new CellFactory();
            }
            return factory;
        }
        private CellFactory() { }
        public Cell createCell(final char type) {
            Cell newCell;
            switch (type) {
                case  'W':
                    newCell = new Woods();
                    break;
                case 'V':
                    newCell = new Volcanic();
                    break;
                case 'L':
                    newCell = new Land();
                    break;
                case 'D':
                    newCell = new Desert();
                    break;
                default:
                    newCell = null;
            }
            return newCell;
        }

}
