package es.palma.democomboajax;

import javax.sql.DataSource;

import org.apache.tomcat.jdbc.pool.XADataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
public class SpringBootProjecte7Config {

	
	@Bean
	@Profile("devel")
	public DataSource dataSource(Environment environment) {
		XADataSource dataSource = new XADataSource();
		dataSource.setDriverClassName(environment.getProperty("spring.datasource.driver-class-name"));
		dataSource.setUsername(environment.getProperty("spring.datasource.username"));
		dataSource.setPassword(environment.getProperty("spring.datasource.password"));
		dataSource.setUrl(environment.getProperty("spring.datasource.url"));
		int num=Integer.parseInt(environment.getProperty("spring.datasource.initial-size"));
		dataSource.setInitialSize(num);
		return dataSource;
	}
}
