package com.vjsb.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vjsb.aopdemo.service.TrafficFortuneService;

public class AroundWithLoggerDemoApp {

	public static void main(String[] args) {

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		MyLoggerConfig.info("\nMain Program: AroundDemoApp");
		
		MyLoggerConfig.info("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		MyLoggerConfig.info("\nMy Fortune is: " + data);
		
		MyLoggerConfig.info("Finished");

		// close the context
		context.close();
	}

}
