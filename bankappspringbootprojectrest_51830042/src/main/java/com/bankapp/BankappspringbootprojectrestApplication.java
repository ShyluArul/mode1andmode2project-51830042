package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@EntityScan(basePackages = {"com.bankapp.model.entities"})

@SpringBootApplication(scanBasePackages = { "com.bankapp", "com.bankapp.config" })

@EnableTransactionManagement
public class BankappspringbootprojectrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankappspringbootprojectrestApplication.class, args);
	}

}
