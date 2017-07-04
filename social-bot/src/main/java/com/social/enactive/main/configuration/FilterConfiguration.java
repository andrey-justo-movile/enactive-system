package com.social.enactive.main.configuration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.social.enactive.main.filter.RequestFilter;

@Component
@Order(Integer.MIN_VALUE)
public class FilterConfiguration implements ServletContextInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        servletContext.addFilter("log_filter", new RequestFilter()).addMappingForUrlPatterns(null, false, "/*");
    }

    
}
