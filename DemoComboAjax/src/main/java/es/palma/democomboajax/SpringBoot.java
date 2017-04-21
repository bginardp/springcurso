package es.palma.democomboajax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SpringBootProjecte7Config.class)
public class SpringBoot {
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot.class, args);
	}
}
