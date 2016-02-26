package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;

/**
 * Created by k586j642 on 2/26/2016.
 */
public class ReconstructItineraryTest extends TestCase {
    public String[][] createTicketsFromString(String ticketStr){
        ticketStr = ticketStr.substring(3,ticketStr.length()-2);
        String[] tickets = ticketStr.split("\\], \\[");
        String[][] result = new String[tickets.length][2];
        for(int i=0;i<tickets.length;i++){
            String[] twoCities = tickets[i].split("\", \"");
            result[i][0] = twoCities[0].replace("\"","");
            result[i][1] = twoCities[1].substring(0,3);
        }
        return result;
    }

    @Test
    public void test1() {
        String[][] tickets = createTicketsFromString("[[\"MUC\", \"LHR\"], [\"JFK\", \"MUC\"], [\"SFO\", \"SJC\"], [\"LHR\", \"SFO\"]]");
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> actual = reconstructItinerary.findItinerary(tickets);
        String[] expected = {"JFK", "MUC", "LHR", "SFO", "SJC"};
        assertNotNull(actual);
        assertEquals(expected.length,actual.size());
        for(int i=0;i<expected.length;i++){
            assertEquals(expected[i],actual.get(i));
        }
    }

    @Test
    public void test2() {
        String[][] tickets = createTicketsFromString("[[\"JFK\", \"SFO\"], [\"JFK\", \"ATL\"], [\"SFO\", \"ATL\"], [\"ATL\", \"JFK\"], [\"ATL\", \"SFO\"]]");
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> actual = reconstructItinerary.findItinerary(tickets);
        String[] expected = {"JFK","ATL","JFK","SFO","ATL","SFO"};
        assertNotNull(actual);
        assertEquals(expected.length,actual.size());
        for(int i=0;i<expected.length;i++){
            assertEquals(expected[i],actual.get(i));
        }
    }

    @Test
    public void test3() {
        String[][] tickets = createTicketsFromString("[[\"JFK\", \"SFO\"], [\"JFK\", \"ATL\"], [\"SFO\", \"ATL\"], [\"ATL\", \"JFK\"], [\"ATL\", \"SFO\"]]");
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> actual = reconstructItinerary.findItinerary(tickets);
        String[] expected = {"JFK","ATL","JFK","SFO","ATL","SFO"};
        assertNotNull(actual);
        assertEquals(expected.length,actual.size());
        for(int i=0;i<expected.length;i++){
            assertEquals(expected[i],actual.get(i));
        }
    }

    @Test
    public void test4() {
        String[][] tickets = createTicketsFromString("[[\"JFK\", \"KUL\"], [\"JFK\", \"NRT\"], [\"NRT\", \"JFK\"]]");
        ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
        List<String> actual = reconstructItinerary.findItinerary(tickets);
        String[] expected = {"JFK","NRT","JFK","KUL"};
        assertNotNull(actual);
        assertEquals(expected.length,actual.size());
        for(int i=0;i<expected.length;i++){
            assertEquals(expected[i],actual.get(i));
        }
    }

}