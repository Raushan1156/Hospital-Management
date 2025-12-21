package com.HospitalManagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@OpenAPIDefinition(
		info = @Info(
				title = "Hospital Management API",
				version = "1.0.0",
				description = "API documentation for Hospital Management system"
		),
		servers = {
				@Server(url = "http://localhost:9001", description = "Local"),
				@Server(url = "https://api.mycompany.com", description = "Prod")
		}
)

@SpringBootApplication
public class HospitalManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(HospitalManagementApplication.class, args);
		System.out.println("JVM TZ = " + TimeZone.getDefault().getID());
	}


}
