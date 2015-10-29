package leetcode;

/**
 * Created by Xinghuang Leon Xu on 10/29/2015.
 */
public class HIndexII {
    public int hIndex(int[] citations) {
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
