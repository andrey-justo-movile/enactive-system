package com.social.enactive.bot.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

import com.social.enactive.bot.configuration.log.Log;
import com.social.enactive.bot.queue.handler.MessagingSenderHandlerRouter;

@Component
public class WebSocketListener {

	@Autowired
	private MessagingSenderHandlerRouter router;
	
    @EventListener
    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
        Log.SYSTEM.info("Received a new web socket connection with {}", event);
    }

    @EventListener
    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        if(username != null) {
        	Log.SYSTEM.info("User Disconnected : " + username);
        	router.removeContainer(username);
        }
    }
	
}
