package com.social.enactive.bot.main;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableAsync
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableEncryptableProperties
@ComponentScan({"com.social.enactive"})
@SpringBootApplication
public class SocialEnactiveImporterMain implements CommandLineRunner {

    public static void main(String[] args) throws InterruptedException {
    	SpringApplication.run(SocialEnactiveImporterMain.class, args);
    }

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
	}

}