package com.social.enactive.bot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.social.enactive.bot.components.authentication.AuthenticationService;
import com.social.enactive.bot.components.user.UserService;
import com.social.enactive.bot.components.user.credentials.UserCredentialsService;
import com.social.enactive.bot.configuration.http.filter.JWTAuthorizationFilter;
import com.social.enactive.bot.configuration.http.filter.JWTLoginFilter;
import com.social.enactive.bot.web.Paths;

import static com.social.enactive.bot.rest.Paths.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserCredentialsService userCredentialsService;
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@Autowired
	private UserService userService;
	
	public static PasswordEncoder DEFAULT_ENCODER = new BCryptPasswordEncoder();

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests()
		.antMatchers("/css/**", "/images/**", "/js/**", "/favicon.ico").permitAll()
		// TODO: create another security config only for web sockets
		.antMatchers("/", "/index", "/channel/**").permitAll()
		.antMatchers(Paths.ANONYMOUS, Paths.ANONYMOUS_SHORT).permitAll()
		.antMatchers(HttpMethod.POST, ANONYMOUS_SESSION).permitAll()
		.antMatchers(HttpMethod.POST, LOGIN, SIGN_UP).permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilterBefore(new JWTLoginFilter(LOGIN, authenticationManager(), authenticationService, userService), 
				UsernamePasswordAuthenticationFilter.class)
		.addFilterBefore(new JWTAuthorizationFilter(authenticationService, authenticationManager()), 
				UsernamePasswordAuthenticationFilter.class)
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userCredentialsService).passwordEncoder(DEFAULT_ENCODER);
	}

}
