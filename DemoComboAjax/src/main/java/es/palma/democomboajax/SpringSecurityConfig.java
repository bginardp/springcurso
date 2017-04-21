package es.palma.democomboajax;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSecurityConfig {
//@EnableWebSecurity
//public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
//	
//	@Autowired
//    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//            .inMemoryAuthentication()
//                .withUser("admin").password("admin").roles("ADMIN");
//    }
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http
//		.authorizeRequests()     
//			// admin
//			.antMatchers("/admin/**").hasRole("ADMIN") 
//			.anyRequest().permitAll()                                                  
//			.and()
//		.formLogin();     
//	}
}
