package com.sp.bdi.doitdoit;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Execute {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("ioc/ioc-6.xml");
		CarMaker c = (CarMaker)ac.getBean("carMaker");
		System.out.println(c.makeCar());
		Car car = (Car)ac.getBean("car");
		System.out.println(car.getCarName());
	}
}
