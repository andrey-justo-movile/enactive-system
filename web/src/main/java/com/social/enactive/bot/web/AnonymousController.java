package com.social.enactive.bot.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.social.enactive.bot.components.conversation.ConversationService;

@Controller
public class AnonymousController {
	
	@Autowired
	private ConversationService conversationService;

	@RequestMapping(path = {Paths.ANONYMOUS, Paths.ANONYMOUS_SHORT})
	public String anonymous(@RequestParam(required = false) String chatId, Model model) {
		if (StringUtils.isNotBlank(chatId)) {
			model.addAttribute("botBehavior", conversationService.findBotIn(chatId));
		}
		
		return "anonymous";
	}
	
}
