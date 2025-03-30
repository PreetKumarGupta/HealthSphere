package HealthSphereApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class HealthSphereApplication {

	public static void main(String[] args) {
		SpringApplication.run(HealthSphereApplication.class, args);
	}

}
