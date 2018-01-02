package com.social.enactive.bot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.social.enactive.bot.components.authentication.AuthenticationService;
import com.social.enactive.bot.components.user.credentials.UserCredentialsService;
import com.social.enactive.bot.configuration.http.filter.JWTAuthorizationFilter;
import com.social.enactive.bot.configuration.http.filter.JWTLoginFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserCredentialsService userCredentialsService;
	
	@Autowired
	private AuthenticationService authenticationService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/css/**", "/images/**", "/js/**", "/favicon.ico").permitAll()
		.antMatchers("/", "/index", "/login").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilter(new JWTLoginFilter(authenticationManager(), authenticationService))
		.addFilter(new JWTAuthorizationFilter(authenticationService, authenticationManager()))
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userCredentialsService);
	}

}
