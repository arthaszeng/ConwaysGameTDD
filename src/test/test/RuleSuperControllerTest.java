

import Rule.*;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class RuleSuperControllerTest {
    @Test
    public void testAddRule() throws Exception {
        RuleController ruleController = new RuleController();
        RuleSuper underpopulation = new UnderPopulationRule();

        assertTrue(ruleController.addRule(underpopulation));
        assertEquals(underpopulation.getClass(), ruleController.rulesList.get(0).getClass());

        assertFalse(ruleController.addRule(underpopulation));
    }

    @Test
    public void testDeleteRule() throws Exception {
        RuleController ruleController = new RuleController();
        RuleSuper underpopulation = new UnderPopulationRule();

        assertTrue(ruleController.addRule(underpopulation));
        assertFalse(ruleController.rulesList.isEmpty());

        assertTrue(ruleController.deleteRule(underpopulation));
        assertTrue(ruleController.rulesList.isEmpty());
    }


    @Test
    public void testMatchOfRuleMatcher() throws Exception {
        char[][] area = Initialization.initByRoll(4, 8, new Roll(50,5));
        RuleController ruleController = new RuleController();
        RuleSuper underpopulation = mock(UnderPopulationRule.class);
        RuleSuper overcrowding = mock(Overcrowding.class);
        ruleController.addRule(underpopulation);
        ruleController.addRule(overcrowding);

        ruleController.iterate(area);

        verify(underpopulation,times(32-8-8-2-2)).match(anyInt(), anyInt(), anyObject());
        verify(overcrowding,times(32-8-8-2-2)).match(anyInt(), anyInt(), anyObject());
    }
}
