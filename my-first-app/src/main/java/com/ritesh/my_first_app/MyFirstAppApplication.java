package com.ritesh.my_first_app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFirstAppApplication implements CommandLineRunner {

	private final Car car;
	public MyFirstAppApplication(Car car){
		this.car = car;
	}

	public static void main(String[] args) {
		SpringApplication.run(MyFirstAppApplication.class, args);
	}

	@Override
	public void run(String... args){
		car.drive();
	}
}
