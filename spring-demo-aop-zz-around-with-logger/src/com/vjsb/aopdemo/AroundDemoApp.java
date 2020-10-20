package com.vjsb.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.vjsb.aopdemo.service.TrafficFortuneService;

public class AroundDemoApp {

	public static void main(String[] args) {
		
		Logger myLogger = Logger.getLogger(AroundWithLoggerDemoApp.class.getName());

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		System.out.println("\nMain Program: AroundDemoApp");
		
		System.out.println("Calling getFortune");
		
		String data = theFortuneService.getFortune();
		
		System.out.println("\nMy Fortune is: " + data);
		
		System.out.println("Finished");

		// close the context
		context.close();
	}

}
