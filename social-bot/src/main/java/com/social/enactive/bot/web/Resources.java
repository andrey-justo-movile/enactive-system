package com.social.enactive.bot.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Resources {

	@RequestMapping(path = {Paths.INDEX, "/"})
	public String index(Model model) {
		return "index";
	}

}
