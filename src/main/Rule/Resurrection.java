package Rule;

public class Resurrection extends RuleSuper {
    @Override
    public boolean match(int x, int y, char[][] area) {
        if (area[x][y] == '.') {
            int deathCell = 0;
            for(int m = x - 1; m <= x + 1; m++) {
                for (int n = y - 1; n <= y + 1; n++) {
                    if (area[m][n] == '.') deathCell++;
                }
            }
            if (deathCell == 8) {
                return true;
            }
        }
        return false;
    }
}
