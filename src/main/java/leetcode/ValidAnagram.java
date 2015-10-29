package leetcode;

/**
 * Created by Xinghuang Leon Xu on 9/4/2015.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] charCounts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            charCounts[t.charAt(i) - 'a']--;
            if (charCounts[t.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
