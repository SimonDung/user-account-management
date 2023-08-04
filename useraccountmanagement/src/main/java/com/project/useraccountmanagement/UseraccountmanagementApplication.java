package com.project.useraccountmanagement;

import com.project.useraccountmanagement.auth.AuthenticationService;
import com.project.useraccountmanagement.auth.RegisterRequest;
import com.project.useraccountmanagement.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class UseraccountmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(UseraccountmanagementApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(
			AuthenticationService service
	) {
		return args -> {
			var admin = RegisterRequest.builder()
					.firstname("admin")
					.lastname("admin")
					.email("admin@gmail.com")
					.password("admin")
					.role(Role.ADMIN)
					.build();
			System.out.println("Admin token: " + service.register(admin).getAccessToken());

			var user = RegisterRequest.builder()
					.firstname("user")
					.lastname("user")
					.email("user@gmail.com")
					.password("user")
					.role(Role.USER)
					.build();
			System.out.println("User token: " + service.register(user).getAccessToken());
		};

	}
}
