package com.packy.springboot2.unittest;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {UnittestApplication.class})
public class SpringBootTestDemo {

	@Test
	public void test() {
		TestCase.assertEquals(1,1);
	}

}
