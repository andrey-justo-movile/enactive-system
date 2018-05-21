package com.social.enactive.bot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class PrivacyPolicyController {
	
	@RequestMapping(path = {Paths.PRIVACY})
	public String privacy() {	
		return "privacy-policy";
	}
	
}
