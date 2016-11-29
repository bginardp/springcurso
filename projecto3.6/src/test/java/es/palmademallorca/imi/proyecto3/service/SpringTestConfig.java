package es.palmademallorca.imi.proyecto3.service;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringTestConfig {

	@Bean
	ProductService productService(){
		return new ProductServiceTestImpl();
	}
}
