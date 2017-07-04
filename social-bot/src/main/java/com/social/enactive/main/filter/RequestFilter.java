package com.social.enactive.main.filter;

import java.io.IOException;
import java.util.Enumeration;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class RequestFilter implements Filter {

    private Logger CORE = LoggerFactory.getLogger("core");
    private static final String STAMP_LABEL = "stamp";

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        RequestFilter.stamp(null);
        StopWatch chronometer = new StopWatch();
        chronometer.start();

        HttpServletRequest httpRequest = (HttpServletRequest) request;

        StringBuilder sb = new StringBuilder();
        sb.append(httpRequest.getMethod().toUpperCase());
        if (StringUtils.isBlank(httpRequest.getHeader("X-Forwarded-For"))) {
            sb.append(" FROM ").append(request.getRemoteAddr());
        } else {
            sb.append(" FROM ").append(httpRequest.getHeader("X-Forwarded-For"));
        }

        if (StringUtils.isNotBlank(httpRequest.getContentType())) {
            sb.append("\t TYPE : ").append(httpRequest.getContentType());
        }
        if (httpRequest.getContentLength() > 0) {
            sb.append("\t LENGTH: ").append(httpRequest.getContentLength());
        }

        sb.append("\t ").append(httpRequest.getRequestURL().toString());
        if (httpRequest.getQueryString() != null) {
            sb.append("?").append(httpRequest.getQueryString());
        }

        sb.append("\t PARAMETERS [");

        Enumeration<String> parameters = request.getParameterNames();

        while (parameters.hasMoreElements()) {
            String name = (String) parameters.nextElement();
            sb.append(" ").append(name).append(": ").append(request.getParameter(name)).append(";");
        }
        CORE.info("{}", sb.append(" ]").toString());
        CORE.debug("Elapsed time: {} ms", chronometer.getTime());

        chain.doFilter(request, response);
    }

    private static void stamp(String stamp) {
        if (StringUtils.isBlank(stamp)) {
            stamp = UUID.randomUUID().toString();
        }

        MDC.put(STAMP_LABEL, stamp.replaceAll("[^0-9a-zA-Z]", ""));
    }

    @Override
    public void destroy() {
    }

}
