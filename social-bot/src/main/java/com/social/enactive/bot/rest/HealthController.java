package com.social.enactive.bot.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @RequestMapping(path = Paths.HEALTH)
    public ResponseEntity<Void> healthCheck() {
        return ResponseEntity.ok().build();
    }
    
}
