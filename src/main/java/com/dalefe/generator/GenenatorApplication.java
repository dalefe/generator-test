package com.dalefe.generator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.dalefe.generator.dao"})
public class GenenatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenenatorApplication.class, args);
	}

}
