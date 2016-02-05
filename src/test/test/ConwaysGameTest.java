

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

public class ConwaysGameTest {
    private Console console;
    private ConwaysGame conwaysGame;

    @Before
    public void setUp() throws Exception {
        console = mock(Console.class);
        conwaysGame = new ConwaysGame(console);
    }

    @Test
    public void testInitialWithDeadCells() throws Exception {
        Roll roll = new Roll(0, 0);
        conwaysGame.init(4, 8, roll);
        conwaysGame.show();

        verify(console, times(32)).print(".");
    }

    @Test
    public void testInitialWith5LiveCells() throws Exception {
        Roll roll = new Roll(100, 5);
        conwaysGame.init(4, 8, roll);
        conwaysGame.show();

        verify(console, times(5)).print("*");
        verify(console, times(27)).print(".");
    }

    @Test
    public void testInitAreaWith5LiveCellAndRateIsNot100() throws Exception {
        Roll roll = new Roll(30, 5);   //the rate of roll is not 100  to make sure of create 5 live cells
        conwaysGame.init(4, 8, roll);
        conwaysGame.show();

        verify(console, times(5)).print("*");
        verify(console, times(27)).print(".");
    }
}
