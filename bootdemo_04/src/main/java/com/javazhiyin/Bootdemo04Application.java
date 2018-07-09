package com.javazhiyin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@MapperScan("com.javazhiyin.dao")
public class Bootdemo04Application {

	public static void main(String[] args) {
		SpringApplication.run(Bootdemo04Application.class, args);
	}
}
