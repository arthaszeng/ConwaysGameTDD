package Rule;

import java.util.ArrayList;
import java.util.List;

public class RuleController {
    public List<RuleSuper> rulesList = new ArrayList<>();

    public boolean addRule(RuleSuper ruleSuper) {
        if (rulesList.contains(ruleSuper)) {
            return false;
        } else {
            rulesList.add(ruleSuper);
            return true;
        }
    }

    public boolean deleteRule(RuleSuper ruleSuper) {
        if (rulesList.contains(ruleSuper)) {
            rulesList.remove(ruleSuper);
            return true;
        }else {
            return false;
        }
    }

    public boolean match(int x, int y, char[][] area) {
        boolean flag = true;
        for (RuleSuper o : rulesList) {
            flag = flag & o.match(x, y, area);
        }
        return flag;
    }

    public char[][] iterate (char[][] area) {
        char[][] buffer = area.clone();
        for (int i = 1; i < area.length - 1; i++) {
            for (int j = 1; j < area[0].length - 1; j++) {
                buffer[i][j] = match(i, j, area) ? '*' : '.';
            }
        }
        return buffer;
    }
}
