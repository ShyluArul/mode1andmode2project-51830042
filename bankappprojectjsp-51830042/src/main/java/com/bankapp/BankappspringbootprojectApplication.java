package com.bankapp;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EntityScan(basePackages = {"com.bankapp.model.entities"})

@SpringBootApplication /* (scanBasePackages={"com.bankapp"}) */
@EnableTransactionManagement
public class BankappspringbootprojectApplication {



	public static void main(String[] args) {
	
	SpringApplication.run(BankappspringbootprojectApplication.class, args);
	}

}
