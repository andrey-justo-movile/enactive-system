package com.social.enactive.bot.main;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.DispatcherServlet;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableAsync
@Configuration
@EnableAutoConfiguration
@EnableConfigurationProperties
@EnableEncryptableProperties
@ComponentScan({"com.social.enactive"})
@SpringBootApplication
public class SocialEnactiveWebMain {

    public static ApplicationContext context;

    @Bean
    public ServletRegistrationBean dispatcherServlet() {
      ServletRegistrationBean registration = new ServletRegistrationBean(
              new DispatcherServlet(), "/");
      registration.setAsyncSupported(true);
      return registration;
    }
    
    public static void main(String[] args) throws InterruptedException {
        context = new SpringApplicationBuilder(SocialEnactiveWebMain.class).bannerMode(Banner.Mode.OFF).run(args);
    }

}