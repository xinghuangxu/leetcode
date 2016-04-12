package leetcode;

import junit.framework.TestCase;
import org.junit.Test;

/**
 * Created by xinghuangxu on 4/2/16.
 */
public class AdditiveNumberTest extends TestCase {

    @Test
    public void test1(){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        assertTrue(additiveNumber.isAdditiveNumber("112358"));
    }

    @Test
    public void test2(){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        assertTrue(additiveNumber.isAdditiveNumber("199100199"));
    }

    @Test
    public void test3(){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        assertFalse(additiveNumber.isAdditiveNumber("2461016264268110179"));
    }

    @Test
    public void test4(){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        assertTrue(additiveNumber.isAdditiveNumber("101"));
    }

    @Test
    public void test5(){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        assertFalse(additiveNumber.isAdditiveNumber("111"));
    }

    @Test
    public void test6(){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        assertTrue(additiveNumber.isAdditiveNumber("198019823962"));
    }

    @Test
    public void test7(){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        assertTrue(additiveNumber.isAdditiveNumber("000000000000"));
    }

    @Test
    public void test8(){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        assertTrue(additiveNumber.isAdditiveNumber("011235"));
    }

    @Test
    public void test9(){
        AdditiveNumber additiveNumber = new AdditiveNumber();
        assertFalse(additiveNumber.isAdditiveNumber("0235813"));
    }

}