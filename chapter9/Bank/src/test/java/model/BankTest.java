package model;

import org.joda.time.DateTime;
import org.joda.time.LocalDateTime;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author evrnsky
 * @version 0.1
 * @since 28.03.2017
 */
public class BankTest {

    /**
     * One hour in milliseconds.
     */
    private static final long HOUR = 3600 * 1000;

    /**
     * Current date.
     */
    private static final LocalDateTime NOW = new LocalDateTime();

    /**
     * Current date with set hour to the 8 a.m.
     */
    private static final DateTime START = new DateTime(NOW.getYear(), NOW.getMonthOfYear(), NOW.getDayOfMonth(), 8, 0, 0, 0);


    /**
     * When only one user came at the one hour and left bank at the same hour.
     */
    @Test
    public void whenCameOnlyOneClientAtOneHoursShouldCheckThatCalculateRight() {
        List<Client> clients = new ArrayList<>();
        long inTime = START.getMillis();
        long outTime = inTime + (HOUR / 2);
        clients.add(new Client(inTime, outTime));
        Bank bank = new Bank(clients);
        List<Client> result = bank.calculate().get("8 - 9");
        assertThat(result.size(), is(1));
    }

    /**
     * When user came in one hour and left bank at the another hour.
     */
    @Test
    public void whenClientCameInTheOneHourAndGoOutAtTheOtherHour() {
        List<Client> clients = new ArrayList<>();
        long inTime = START.getMillis();
        long outTime = inTime + (2 * HOUR);
        clients.add(new Client(inTime, outTime));
        Bank bank = new Bank(clients);
        Map<String, List<Client>> result = bank.calculate();
        List<Client> eightToNine = result.get("8 - 9");
        List<Client> nineToTen = result.get("9 - 10");
        assertThat(eightToNine.size(), is(1));
        assertThat(nineToTen.size(), is(1));
    }

    /**
     * When came many users at the different times and left at the different times.
     */
    @Test
    public void whenComeMoreThanOneClientShouldCheckThatAllWorksFine() {
        List<Client> clients = new ArrayList<>();
        int[] expected = {1, 2, 3, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        long timeIn = START.getMillis();
        clients.add(new Client(timeIn, timeIn + HOUR)); //Came at 8 a.m. and left at 9 a.m.
        clients.add(new Client(timeIn + HOUR, timeIn + 3 * HOUR)); //Came at 9 a.m. and left at 11 a.m.
        clients.add(new Client(timeIn + HOUR, timeIn + 4 * HOUR)); //Came at 9 a.m. and left at 12 p.m.
        clients.add(new Client(timeIn + 2 * HOUR, timeIn + 5 * HOUR)); //Came at 10 a.m. and left at 1 p.m.
        Bank bank = new Bank(clients);
        int index = 0;
        for (Map.Entry<String, List<Client>> entry : bank.calculate().entrySet()) {
            assertThat(entry.getValue().size(), is(expected[index++]));
        }
    }

}