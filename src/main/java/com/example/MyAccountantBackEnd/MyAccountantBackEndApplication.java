package com.example.MyAccountantBackEnd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
@Async
public class MyAccountantBackEndApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAccountantBackEndApplication.class, args);
	}

}
