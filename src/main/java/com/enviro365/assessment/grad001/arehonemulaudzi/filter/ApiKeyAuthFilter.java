package com.enviro365.assessment.grad001.arehonemulaudzi.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@Slf4j
public class ApiKeyAuthFilter extends OncePerRequestFilter {

    @Value("${api.key}")
    private String apiKey;
    @Value("${api.secret}")
    private String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        //Get API key and Secret key from request headers
        String requestApiKey = request.getHeader("X-API-KEY");
        String requestSecretKey = request.getHeader("X-API-SECRET");

        log.info("Api key: {} " , requestApiKey);

        //Validation of secretKey and apiKey

        if (requestApiKey.equals(apiKey) && requestSecretKey.equals(secretKey)) {
            filterChain.doFilter(request,response);
            log.info("Authenticated....");
        } else {
            response.setStatus(HttpStatus.UNAUTHORIZED.value());
            response.getWriter().write("Unauthorized");
        }

    }
}
