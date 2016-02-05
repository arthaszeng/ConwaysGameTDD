

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComponentTest {

    @Test
    public void testConsole() throws Exception {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Console console = new Console();
        console.print("123");

        assertEquals("123", outContent.toString());
    }

    @Test
    public void testRollShouldReturnAllLiveCell() throws Exception {
        Roll roll = new Roll(100 ,5);

        char[] result = new char[5];
        result[0] = roll.roll();
        result[1] = roll.roll();
        result[2] = roll.roll();
        result[3] = roll.roll();
        result[4] = roll.roll();

        assertTrue(result.length == 5);
        assertEquals('*', result[0]);
        assertEquals('*', result[1]);
        assertEquals('*', result[2]);
        assertEquals('*', result[3]);
        assertEquals('*', result[4]);
    }

    @Test
    public void testRollShouldReturnAllDeadCell() throws Exception {
        Roll roll = new Roll(0 ,5);

        char[] result = new char[5];
        result[0] = roll.roll();
        result[1] = roll.roll();
        result[2] = roll.roll();
        result[3] = roll.roll();
        result[4] = roll.roll();

        assertTrue(result.length == 5);
        assertEquals('.', result[0]);
        assertEquals('.', result[1]);
        assertEquals('.', result[2]);
        assertEquals('.', result[3]);
        assertEquals('.', result[4]);
    }

    @Test
    public void testInitialAreaWithDeadCell() throws Exception {
        Roll roll = new Roll(0, 0);
        char[][] area = Initialization.initByRoll(4, 8, roll);

        assertEquals(4, area.length);
        assertEquals(8, area[0].length);

        assertEquals('.', area[0][0]);  //head of area
        assertEquals('.', area[1][2]);  //middle
        assertEquals('.', area[2][4]);  //middle
        assertEquals('.', area[3][7]);  //tail of area
    }

    @Test
    public void testInitAreaWith5LiveCell() throws Exception {
        Roll roll = new Roll(100,5);
        char[][] area = Initialization.initByRoll(4, 8, roll);

        assertEquals(4, area.length);
        assertEquals(8, area[0].length);
        assertEquals('*', area[1][1]);  //first 5 cells will live
        assertEquals('*', area[1][2]);
        assertEquals('*', area[1][3]);
        assertEquals('*', area[1][4]);
        assertEquals('*', area[1][5]);

        assertEquals('.', area[0][0]);  //the others will die
        assertEquals('.', area[1][6]);
        assertEquals('.', area[2][4]);
        assertEquals('.', area[3][7]);
    }

}
