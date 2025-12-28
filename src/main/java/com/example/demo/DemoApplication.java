package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println(new BCryptPasswordEncoder().encode("neljoe"));
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		if(encoder.matches("neljoe", "$2a$10$RqbLOIwDeRVaG2ck2V3aae3a7ina/g26g6DuR2aq.3chxq2VS/uLm")){
			System.out.println("password matched");
		}else{
			System.out.println("no match");
		}
	}

}
