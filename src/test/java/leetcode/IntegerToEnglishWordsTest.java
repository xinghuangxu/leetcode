package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 3/22/16.
 */
public class IntegerToEnglishWordsTest extends TestCase {
    /*
    123 -> "One Hundred Twenty Three"
    12345 -> "Twelve Thousand Three Hundred Forty Five"
    1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
     */
    @Test
    public void test1() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        int num = 123;
        String actualString = integerToEnglishWords.numberToWords(num);
        String expected = "One Hundred Twenty Three";
        assertEquals(expected, actualString);
    }

    @Test
    public void test2() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        int num = 12345;
        String actualString = integerToEnglishWords.numberToWords(num);
        String expected = "Twelve Thousand Three Hundred Forty Five";
        assertEquals(expected, actualString);
    }

    @Test
    public void test3() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        int num = 1234567;
        String actualString = integerToEnglishWords.numberToWords(num);
        String expected = "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven";
        assertEquals(expected, actualString);
    }

    //1234567891
    @Test
    public void test4() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        int num = 1234567891;
        String actualString = integerToEnglishWords.numberToWords(num);
        String expected = "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One";
        assertEquals(expected, actualString);
    }

    public void test5() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        int num = 0;
        String actualString = integerToEnglishWords.numberToWords(num);
        String expected = "Zero";
        assertEquals(expected, actualString);
    }

    public void test6() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        int num = 20;
        String actualString = integerToEnglishWords.numberToWords(num);
        String expected = "Twenty";
        assertEquals(expected, actualString);
    }

    public void test7() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        int num = 100;
        String actualString = integerToEnglishWords.numberToWords(num);
        String expected = "One Hundred";
        assertEquals(expected, actualString);
    }

    public void test8() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        int num = 1000;
        String actualString = integerToEnglishWords.numberToWords(num);
        String expected = "One Thousand";
        assertEquals(expected, actualString);
    }

    public void test9() {
        IntegerToEnglishWords integerToEnglishWords = new IntegerToEnglishWords();
        int num = 1000000;
        String actualString = integerToEnglishWords.numberToWords(num);
        String expected = "One Million";
        assertEquals(expected, actualString);
    }
}