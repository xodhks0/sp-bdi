package com.sp.bdi.test.test4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc/ioc-4.xml");
		Computer c = (Computer)ac.getBean("computer");
		
		Monitor m = (Monitor)ac.getBean("monitor");
		Monitor m1 = (Monitor)ac.getBean("monitor");
		System.out.println(m==m1);//scope가 같기 때문에 true가 나오지만 모니터클래스에서 scope를 prototype으로 설정하면 false가 나온다
		System.out.println(c);
	}
}
