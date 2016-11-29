package es.palmademallorca.imi.proyecto3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages="es.palmademallorca.imi.proyecto3.jpa")
public class SpringBoot {
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot.class, args);
	}
}
