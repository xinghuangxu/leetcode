package hackerrank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/**
 * Created by Xinghuang Leon Xu on 10/10/2015.
 */
public class PalindromeIndex {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        LinkedList<String> stringList = new LinkedList<String>();
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            br.readLine();
            String input;
            while ((input = br.readLine()) != null) {
                stringList.add(input);
            }
        } catch (IOException io) {
            io.printStackTrace();
        }
        for (String s : stringList) {
            System.out.println(palindromeIndex(s, 0,s.length()-1));
        }
    }

    public static int palindromeIndex(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                if (s.charAt(left + 1) == s.charAt(right) && -1 == palindromeIndex(s, left + 2, right - 1)) {
                    return left;
                } else if (s.charAt(left) == s.charAt(right - 1)&& -1 == palindromeIndex(s,left+1, right-2)) {
                        return right;
                } else {
                    return s.length() - 1;
                }
            }
            left++;
            right--;
        }
        return -1;
    }

    /*
    A cleanner solution by Jingyi
        public static void main(String[] args) throws IOException {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    br.readLine();
    String input;

    while((input = br.readLine()) != null) {
        int result = -1;
        for (int left = 0, right = input.length() - 1; left < right; ++left, --right) {
            if (input.charAt(left) != input.charAt(right)) {
                result = isPalindrome(input, left + 1, right) ? left : right;
                break;
            }
        }
        System.out.println(result);
    }
}

    private static boolean isPalindrome(String input, int start, int end) {
        for (int left = start, right = end; left < right; ++left, --right) {
            if (input.charAt(left) != input.charAt(right)) {
                return false;
            }
        }
        return true;
    }
     */

}
