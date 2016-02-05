public class Initialization {
    private static int liveCells;
    private static int maxLiveCells;
    private static int line;
    private static int row;

    public static char[][] initByRoll(int line, int row, Roll roll) {
        maxLiveCells = roll.getMaxLiveCell();
        char[][] area = new char[line][row];
        liveCells = 0;
        int turn = 0;
        Initialization.line = line;
        Initialization.row = row;

        initEdge(area);

        while (turn < 1 || liveCells < maxLiveCells) {
            for (int i = 1; i < line - 1; i++) {
                for (int j = 1; j < row - 1; j++) {
                    if (area[i][j] == '.') {
                        area[i][j] = checkCell(roll.roll());
                    }
                }
            }
            turn++;
        }
        return area;
    }

    private static void initEdge(char[][] area) {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                area[i][j] = '.';
            }
        }
    }

    private static char checkCell(char cell) {
        if (cell == '*' && liveCells <= maxLiveCells) {
            liveCells++;
            return '*';
        }else {
            return '.';
        }
    }
}
