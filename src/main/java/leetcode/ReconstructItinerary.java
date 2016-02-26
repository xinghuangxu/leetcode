package leetcode;

import java.util.*;

/**
 * Created by k586j642 on 2/26/2016.
 */
public class ReconstructItinerary {

    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> maps = new HashMap();
        List<String> value;
        for (int i = 0; i < tickets.length; i++) {
            if (!maps.containsKey(tickets[i][0])) {
                maps.put(tickets[i][0], new ArrayList<String>());
            }
            value = maps.get(tickets[i][0]);
            value.add(tickets[i][1]);
        }
        for (String k : maps.keySet()) {
            Collections.sort(maps.get(k));
        }
        List<String> result = new ArrayList<String>();
        result.add("JFK");
        searchForIternarary(maps, result, tickets.length);
        return result;
    }

    public boolean searchForIternarary(Map<String, List<String>> map, List<String> record, int remain) {
        if (remain == 0) return true;
        List<String> nextAirport = map.get(record.get(record.size() - 1));
        if (nextAirport == null) return false;
        for (int i = 0; i < nextAirport.size(); i++) {
            String nextDestination = nextAirport.remove(i);
            record.add(nextDestination);
            if (searchForIternarary(map, record, remain - 1)) {
                return true;
            }
            nextAirport.add(i, nextDestination);
            record.remove(record.size() - 1);
        }
        return false;
    }
}
