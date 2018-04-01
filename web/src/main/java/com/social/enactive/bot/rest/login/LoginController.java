package com.social.enactive.bot.rest.login;



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
import com.social.enactive.bot.configuration.http.filter.to.UserLogged;
import com.social.enactive.bot.rest.Paths;
import com.social.enactive.bot.rest.login.to.UserSignUpRequest;

@RestController
public class LoginController {
	
	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserCredentialsService userCredentialsService;
	
	@RequestMapping(path = Paths.SIGN_UP, method = RequestMethod.POST)
	public ResponseEntity<UserLogged> signUp(@RequestBody(required = true) UserSignUpRequest request) {
		UserCredentials oldCredentials = userCredentialsService.findByUserName(request.getUsername());
		if (oldCredentials != null) {
			return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
		}
		
		User newUser = userService.create(request.getUsername(), request.getName(), request.getPicture(), request.getEmail());
		UserCredentials credentials = userCredentialsService.create(request.getUsername(), request.getPassword());
		String token = authenticationService.authenticate(credentials.getUsername());
		return ResponseEntity.ok().body(new UserLogged(newUser, token));
	}

}
