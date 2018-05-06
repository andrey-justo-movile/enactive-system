package com.social.enactive.bot.configuration.components;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.social.enactive.bot.configuration.http.filter.RequestFilter;

@WebFilter(pported = true)
@Component
@Order(Integer.MIN_VALUE)
public class FilterConfiguration implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addFilter("log_filter", new RequestFilter()).addMappingForUrlPatterns(null, false, "/*");
    }

    
}
