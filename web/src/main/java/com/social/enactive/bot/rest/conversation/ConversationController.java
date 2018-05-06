package com.social.enactive.bot.rest.conversation;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cloudinary.Cloudinary;
import com.social.enactive.bot.components.conversation.Conversation;
import com.social.enactive.bot.components.conversation.ConversationService;
import com.social.enactive.bot.components.scenario.BehaviorScenario;
import com.social.enactive.bot.components.scenario.BotBehaviorService;
import com.social.enactive.bot.components.user.UserService;
import com.social.enactive.bot.rest.Paths;
import com.social.enactive.bot.rest.conversation.to.JoinConversation;

@RestController
public class ConversationController {

    @Autowired
    private ConversationService conversationService;

    @Autowired
    private UserService userService;

    @Autowired
    private BotBehaviorService botBehaviorService;

    @Autowired
    private Cloudinary cloudinary;

    @RequestMapping(path = Paths.CONVERSATION, method = RequestMethod.POST)
    public ResponseEntity<Conversation> joinConversation(@RequestBody(required = false) JoinConversation join) {
        return ResponseEntity.ok()
                .body(conversationService.joinConversation(join.getConversationId(),
                        userService.find(join.getUserId()),
                        botBehaviorService.find(BehaviorScenario.valueOf(join.getBotBehavior())),
                        join.getType()));
    }

    @RequestMapping(path = Paths.UPLOAD, method = RequestMethod.POST)
    public ResponseEntity<Void> upload(HttpServletResponse response, @PathVariable("conversation") String conversation) {
        return ResponseEntity.ok().build();
    }

}