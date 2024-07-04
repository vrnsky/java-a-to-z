package model;

import org.junit.Test;
import ru.evrnsky.start.StubIO;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 16.04.2017
 *
 * It is unit test for game io implementation.
 */
public class GameIOTest {

    /**
     * When try println should check that all is ok.
     */
    @Test
    public void whenTryPrintlnShouldCheckThatAllIsOk() {
        StubIO stubIO = new StubIO(new String[]{"data"});
        GameIO io = new GameIO(stubIO);
        io.println("new value");
        assertThat(stubIO.getOut(), is("new value\n"));
    }

    /**
     * When try print should check that all is ok.
     */
    @Test
    public void whenTryPrintShouldCheckThatAllIsOk() {
        StubIO stub = new StubIO(new String[]{"yegor"});
        GameIO io = new GameIO(stub);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        io.print("data");
        assertThat(outputStream.toString(), is("data"));
    }

    /**
     * When try ask shoudl check that game io return correct data.
     */
    @Test
    public void whenTryAskShouldCheckThatGameIOReturnCorrectData() {
        StubIO stub = new StubIO(new String[]{"value"});
        GameIO io = new GameIO(stub);
        String actual = io.ask("type a new value");
        assertThat(actual, is("value"));
    }

    /**
     * When try ask a number should check that game io return correct number.
     */
    @Test
    public void whenTryAskANumberShouldCheckThatGameIOReturnCorrectNumber() {
        StubIO stub = new StubIO(new String[]{"5"});
        GameIO io = new GameIO(stub);
        int actual = io.ask("type a number", 1, 10);
        assertThat(actual, is(5));
    }
}