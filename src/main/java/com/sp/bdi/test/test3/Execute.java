package com.sp.bdi.test.test3;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc/ioc-3.xml");
		Cook c = (Cook)ac.getBean("cook");		
		System.out.println(c.getF());
	}
}