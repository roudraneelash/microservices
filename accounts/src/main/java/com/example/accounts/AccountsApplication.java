package com.example.accounts;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
// if the controller and rest package is different from the main package
/*
* @ComponentScan(basePackages = {"com.example.accounts.controller", "com.example.accounts.rest"})
* @EnableJpaRepositories(basePackages = {"com.example.accounts.repository"})
* @EntityScan(basePackages = {"com.example.accounts.entity"})
* */
@EnableJpaAuditing(auditorAwareRef = "auditAwareImpl")
@OpenAPIDefinition(info = @Info(
		title = "Accounts Management API",
		version = "1.0",
		description = "API for managing customer accounts",
		contact = @Contact(
				name = "Madan Reddy",
				email = "tutor@eazybytes.com",
				url = "https://eazybytes.com/contacts"
		),
		license = @License(
				name = "Apache 2.0",
				url = "https://www.apache.org/licenses/LICENSE-2.0"
		)
))
public class AccountsApplication {

	public static void main(String[] args) {
		SpringApplication.run(AccountsApplication.class, args);
	}

}
