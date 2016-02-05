import Rule.Overcrowding;
import Rule.Resurrection;
import Rule.RuleController;
import Rule.UnderPopulationRule;

public class Main {

    public static void main(String[] args) {
        ConwaysGame conwaysGame = new ConwaysGame(new Console());
        conwaysGame.init(4,8, new Roll(5, 10));
        RuleController ruleController = new RuleController();

        ruleController.addRule(new Overcrowding());
        ruleController.addRule(new Resurrection());
        ruleController.addRule(new UnderPopulationRule());


        for (int i = 0; i < 10000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            conwaysGame.iterate(ruleController);
            conwaysGame.show();
            System.out.println();
        }
    }
}
