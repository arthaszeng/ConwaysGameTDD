public class Roll {
    private int liveCell = 0;
    private int threshold;
    private int maxLiveCell;

    public Roll(int threshold, int maxLiveCell) {
        this.threshold = threshold;
        this.maxLiveCell = maxLiveCell;
    }


    public char roll() {
        if ((threshold >= (int)(Math.random() * 100)) && liveCell < maxLiveCell) {
            liveCell++;
            return '*';
        } else {
            return '.';
        }
    }

    public int getMaxLiveCell() {
        return maxLiveCell;
    }

}
