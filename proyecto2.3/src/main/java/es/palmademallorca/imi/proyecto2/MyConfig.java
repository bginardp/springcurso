package es.palmademallorca.imi.proyecto2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import es.palmademallorca.imi.proyecto2.component.ComponentOne;
import es.palmademallorca.imi.proyecto2.component.ComponentOneImpl;

@Configuration
public class MyConfig {

	@Bean
	ComponentOne componentOne(){
		ComponentOne result= new ComponentOneImpl();
		return result;
	}
}
