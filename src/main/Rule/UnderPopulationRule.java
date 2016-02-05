package Rule;

public class UnderPopulationRule extends RuleSuper {

    @Override
    public boolean match(int x, int y, char[][] area) {
        if (area[x][y] == '*') {
            int numLive = 0;
            for (int m = x - 1; m <= x + 1; m++) {
                for (int n = y - 1; n <= y + 1; n++) {
                    if (area[m][n] == '*') {
                        numLive++;
                    }
                }
            }
            if (numLive < 2) {
                return false;
            }
        }
        return true;
    }
}
