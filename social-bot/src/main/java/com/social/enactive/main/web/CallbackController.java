package com.social.enactive.main.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/callback")
public class CallbackController {
    
    private Logger SYSTEM = LoggerFactory.getLogger("system");
    
    private static String secretToken = "test";
    
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<String> validate(@RequestParam("hub.verify_token") String token, @RequestParam("hub.challenge") String challenge) {
        if (secretToken.equals(token)) {
            SYSTEM.info("Webhook validation: TOKEN is valid!");
            return ResponseEntity.ok(challenge);
        } else {
            SYSTEM.error("Webhook validation: invalid token!");
            return ResponseEntity.badRequest().body("ERROR");
        }
    }

}
