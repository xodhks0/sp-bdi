package com.sp.bdi.test.test1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("/ioc/ioc-1.xml");
		Cat c = (Cat)ac.getBean("c");
		
		System.out.println(ac.getBean("c"));
		c.setAge(20);
		c.setName("개");
		System.out.println(c);
		c = null;
		System.out.println(ac.getBean("c"));
		System.out.println(c);
		Human h = (Human)ac.getBean("h");
		System.out.println(h);
	}
}
