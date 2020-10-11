package com.dpworld.demo.security;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CorsFilter implements Filter {

   public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {

      HttpServletResponse response = (HttpServletResponse) res;
      HttpServletRequest request = (HttpServletRequest) req;
      response.setHeader("Access-Control-Allow-Origin", "*");
      response.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
      response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept, Authorization, Access-Control-Allow-Origin, Cache-Control, REMOTE_USER, Access-Control-Allow-Headers, Access-Control-Allow-Methods");
      response.setHeader("Access-Control-Max-Age", "3600");
      if (request.getMethod() != "OPTIONS") {
         chain.doFilter(request, response);
      }
   }

   public void init(FilterConfig filterConfig) {
   }

   public void destroy() {
   }

}

