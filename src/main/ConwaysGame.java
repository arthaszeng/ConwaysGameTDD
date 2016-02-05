import Rule.RuleController;

public class ConwaysGame {
    private char[][] area;
    private int line;
    private int row;
    private Console console;


    public ConwaysGame(Console console) {
        this.console = console;
    }


    public void init(int line, int row, Roll roll) {
        area = Initialization.initByRoll(line, row, roll);
        this.line = line;
        this.row = row;
    }

    public void iterate (RuleController ruleController) {
        area = ruleController.iterate(area);
    }

    public void show() {
        for (int i = 0; i < line; i++) {
            for (int j = 0; j < row; j++) {
                console.print(String.valueOf(area[i][j]));
            }
            console.print("\n");
        }
        console.print("\n");
    }
}
