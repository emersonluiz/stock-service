package br.com.controlunion.stock.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
	    httpSecurity.authorizeRequests()
			.antMatchers(HttpMethod.OPTIONS, "**").permitAll()
		    .antMatchers("/**").permitAll()
			.antMatchers("/img/**").permitAll()
			.antMatchers("/stock/**").permitAll()
			.antMatchers("/products/**").permitAll()
			.antMatchers("/sizes/**").permitAll()
			.antMatchers("/console/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.addFilterBefore(new JwtFilterSecurity(), UsernamePasswordAuthenticationFilter.class);
	    
	    httpSecurity.csrf().disable();
	    httpSecurity.headers().frameOptions().disable();
	}

}
