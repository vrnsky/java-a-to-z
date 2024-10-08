package start;

import org.junit.jupiter.api.Test;
import ru.evrnsky.start.StubIO;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


/**
 * Unit test for MenuDemo.java.
 */
class MenuDemoTest {

    /**
     * When show menu from menu demo should check that showing correct.
     */
    @Test
    void whenMenuStartShouldCheckThatIsCorrectLook() {

        //Assign block
        String[] answer = new String[]{"", "", ""};
        StubIO stubIO = new StubIO(answer);
        MenuDemo menuDemo = new MenuDemo();
        String expected = "1.Choose server \n"
                +
                "1.1.Tomcat \n"
                +
                "1.1.1.Start \n"
                +
                "2.Settings \n"
                +
                "2.1.Storage \n"
                +
                "2.1.1.1024 TB \n"
                +
                "2.1.2.2048 TB \n";

        menuDemo.init(stubIO);
        assertThat(stubIO.getOut(), is(expected));
    }
}
