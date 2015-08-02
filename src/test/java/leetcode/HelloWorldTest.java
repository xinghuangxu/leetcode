package leetcode;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class HelloWorldTest {

	@Test
	public void test() {
		System.out.println("Sdfls");
		HelloWorld helloworld=new HelloWorld();
		assertEquals(helloworld.output(), "Hello World");
	}

}
