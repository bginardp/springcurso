package es.palmademallorca.imi.proyecto4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpringSecurityConfig.class)
public class SpringBoot {
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot.class, args);
	}
}
