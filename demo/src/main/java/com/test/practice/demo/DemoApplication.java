package com.test.practice.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {


	public static void main(String[] args) {
		Test test = new Test();
		test.testMethod();



		System.out.println("Main method: TestClass Class => " + "");
	}



}
