package com.social.enactive.bot.main;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.social.enactive.bot.components.knowledge.KnowledgeCsvService;
import com.social.enactive.bot.configuration.log.Log;
import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableAsync
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableEncryptableProperties
@ComponentScan({"com.social.enactive"})
@SpringBootApplication
public class SocialEnactiveImporterMain implements ApplicationRunner {

	private KnowledgeCsvService knowledgeCsvService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Log.SYSTEM.info("Importer running with {}", args);
		knowledgeCsvService.extract(args.getNonOptionArgs().get(0), args.getNonOptionArgs().get(1));
	}

}