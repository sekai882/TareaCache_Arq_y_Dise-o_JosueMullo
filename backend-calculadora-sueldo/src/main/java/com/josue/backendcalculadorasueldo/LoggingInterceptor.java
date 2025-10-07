package com.josue.backendcalculadorasueldo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoggingInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("🛰️ Proxy -> " + request.getMethod() + " " + request.getRequestURI() + " desde " + request.getRemoteAddr());
        return true; // permite que la petición continúe
    }
}
