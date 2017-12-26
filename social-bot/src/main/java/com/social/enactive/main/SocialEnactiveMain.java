package com.social.enactive.main;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySource;
import com.ulisesbocchio.jasyptspringboot.annotation.EncryptablePropertySources;

@EnableAsync
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@ComponentScan({"com.social.enactive"})
@SpringBootApplication
@EnableEncryptableProperties
@EncryptablePropertySources({@EncryptablePropertySource("classpath:encrypted.yml")})
public class SocialEnactiveMain {

    public static ApplicationContext context;

    public static void main(String[] args) throws InterruptedException {
        context = new SpringApplicationBuilder(SocialEnactiveMain.class).bannerMode(Banner.Mode.OFF).run(args);
    }

}