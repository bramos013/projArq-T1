package com.trabalho1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.trabalho1" })
@EntityScan(basePackages = { "com.trabalho1" })
public class CtrlEspacoAereo {

	public static void main(String[] args) {
		SpringApplication.run(CtrlEspacoAereo.class, args);
	}

}
