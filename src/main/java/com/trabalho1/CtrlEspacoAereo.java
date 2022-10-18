package com.trabalho1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@ComponentScan(basePackages = { "com.trabalho1" })
@EntityScan(basePackages = { "com.trabalho1" })
public class CtrlEspacoAereo {

	public static void main(String[] args) {
		SpringApplication.run(CtrlEspacoAereo.class, args);
	}

}
