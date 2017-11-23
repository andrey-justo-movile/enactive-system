package com.social.enactive.bot.rest.conversation;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.social.enactive.bot.rest.Paths;
import com.social.enactive.bot.rest.conversation.to.Conversation;

@RestController
public class ConversationController {

	@RequestMapping(path = Paths.CONVERSATION, method = RequestMethod.POST)
    public ResponseEntity<Void> sendConversation(@RequestBody Conversation conversation) {
        return ResponseEntity.ok().build();
    }
	
	@RequestMapping(path = Paths.START_CONVERSATION, method = RequestMethod.POST)
    public ResponseEntity<String> startConversation() {
        return ResponseEntity.ok().body(UUID.randomUUID().toString());
    }
	
}
