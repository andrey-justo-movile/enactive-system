package com.social.enactive.bot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AnonymousController {

	@RequestMapping(path = {Paths.ANONYMOUS, Paths.ANONYMOUS_SHORT})
	public String anonymous(@RequestParam String chatId, Model model) {
		return "anonymous";
	}
	
}
