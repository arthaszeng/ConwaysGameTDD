import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class ComponentTest {

    @Test
    public void testConsole() throws Exception {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Console console = new Console();
        console.print("123");

        assertEquals("123", outContent.toString());
    }


}
