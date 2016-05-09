package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by k586j642 on 5/9/2016.
 */
public class FlipGame {

    public List<String> generatePossibleNextMoves(String s) {
        List<String> result = new ArrayList();
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (sb.length() > i + 1) {
            if (sb.charAt(i) == '+' && sb.charAt(i + 1) == '+') {
                sb.setCharAt(i, '-');
                sb.setCharAt(i + 1, '-');
                result.add(sb.toString());
                sb.setCharAt(i, '+');
                sb.setCharAt(i + 1, '+');
            }
            i++;
        }
        return result;
    }

}
