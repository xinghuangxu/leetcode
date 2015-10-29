package leetcode;

import java.util.Arrays;

/**
 * Created by Xinghuang Leon Xu on 9/4/2015.
 */
public class HIndex {

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int hindex = citations.length;
        for (int i = 0; i < citations.length; i++) {
            if (citations[i] >= hindex) {
                return hindex;
            }
            hindex--;
        }
        return 0;
    }
}
