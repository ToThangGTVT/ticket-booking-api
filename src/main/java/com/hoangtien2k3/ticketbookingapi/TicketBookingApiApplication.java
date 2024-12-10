package com.hoangtien2k3.ticketbookingapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@SecurityRequirement(name = "bearerAuth")
public class TicketBookingApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketBookingApiApplication.class, args);
	}

}
