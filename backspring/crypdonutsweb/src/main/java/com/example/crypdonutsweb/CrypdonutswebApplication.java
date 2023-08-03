package com.example.crypdonutsweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.crypdonutsweb")
public class CrypdonutswebApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrypdonutswebApplication.class, args);
	}

}
