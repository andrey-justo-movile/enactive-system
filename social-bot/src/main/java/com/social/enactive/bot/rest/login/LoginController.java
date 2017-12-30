package com.social.enactive.bot.rest.login;


import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.enactive.bot.components.authentication.AuthenticationService;
import com.social.enactive.bot.components.user.User;
import com.social.enactive.bot.components.user.UserService;
import com.social.enactive.bot.components.user.credentials.UserCredentials;
import com.social.enactive.bot.components.user.credentials.UserCredentialsService;
import com.social.enactive.bot.rest.Paths;
import com.social.enactive.bot.rest.login.to.UserLogged;
import com.social.enactive.bot.rest.login.to.UserSignUpRequest;

@RestController
public class LoginController {

	private static final String DEFAULT_AUTH_ALG_VERSION = "default";
	
	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCredentialsService userCredentialsService;

	@RequestMapping(path = Paths.LOGIN, method = RequestMethod.POST)
	public ResponseEntity<UserLogged> login(@RequestBody(required = true) UserCredentials credentials) {
		String token = authenticationService.authenticate(credentials.getName(), credentials.getPassword());
		if (StringUtils.isBlank(token)) {
			return ResponseEntity.notFound().build();
		}

		User user = userService.findByUserName(credentials.getName());
		return ResponseEntity.ok().body(new UserLogged(user, token));
	}
	
	@RequestMapping(path = Paths.SIGN_UP, method = RequestMethod.POST)
	public ResponseEntity<UserLogged> signUp(@RequestBody(required = true) UserSignUpRequest request) {
		UserCredentials oldCredentials = userCredentialsService.findByUserName(request.getUsername());
		if (oldCredentials != null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
		User newUser = userService.create(request.getName(), request.getUsername(), request.getPicture());
		UserCredentials credentials = userCredentialsService.create(request.getUsername(), request.getPicture(), DEFAULT_AUTH_ALG_VERSION);
		String token = authenticationService.authenticate(credentials.getName(), credentials.getPassword());
		return ResponseEntity.ok().body(new UserLogged(newUser, token));
	}

}
