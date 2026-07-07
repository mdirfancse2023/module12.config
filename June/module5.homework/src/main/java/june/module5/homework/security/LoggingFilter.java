package june.module5.homework.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.jspecify.annotations.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class LoggingFilter extends OncePerRequestFilter {

    private static final Logger logger = LoggerFactory.getLogger(LoggingFilter.class);

    @Override
    protected void doFilterInternal(HttpServletRequest request, @NonNull HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // Start time
        long startTime = System.currentTimeMillis();

        // Request Details
        String method = request.getMethod();

        String uri = request.getRequestURI();

        String ipAddress = request.getRemoteAddr();

        String userAgent = request.getHeader("User-Agent");

        logger.info("============== REQUEST START ==============");

        logger.info("HTTP Method: {}", method);

        logger.info("Request URI: {}", uri);

        logger.info("Client IP: {}", ipAddress);

        logger.info("User Agent: {}", userAgent);

        try {

            // Continue filter chain
            filterChain.doFilter(request, response);

        } finally {

            // End time
            long endTime = System.currentTimeMillis();

            long totalTime = endTime - startTime;

            logger.info("============== RESPONSE END ==============");

            logger.info("Response Status: {}", response.getStatus());

            logger.info("Execution Time: {} ms", totalTime);
        }
    }
}