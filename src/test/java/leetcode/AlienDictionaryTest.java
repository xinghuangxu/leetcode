package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 4/13/16.
 */
public class AlienDictionaryTest extends TestCase {
    @Test
    public void test1(){
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"wrt",
                "wrf",
                "er",
                "ett",
                "rftt"};
        assertEquals("wertf",alienDictionary.alienOrder(words));
    }

    @Test
    public void test2(){
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"z",
                "z"};
        assertEquals("z", alienDictionary.alienOrder(words));
    }

    @Test
    public void test3(){
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"ab",
                "adc"};
        assertEquals("cbda", alienDictionary.alienOrder(words));
    }

    @Test
    public void test4(){
        AlienDictionary alienDictionary = new AlienDictionary();
        String[] words = {"a",
                "b","a"};
        assertEquals("", alienDictionary.alienOrder(words));
    }
}