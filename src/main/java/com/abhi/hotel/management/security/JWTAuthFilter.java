package com.abhi.hotel.management.security;

import com.abhi.hotel.management.constants.Constants;
import com.abhi.hotel.management.utils.JWTUtils;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.CachingUserDetailsService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@RequiredArgsConstructor
public class JWTAuthFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;
    private final CachingUserDetailsService cachingUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        final String authHeader = request.getHeader(Constants.JWT_HEADER);
        final String jwtToken;
        final String userEmail;

        if(authHeader == null || authHeader.isBlank()) {
            filterChain.doFilter(request, response);
            return;
        }else {

            jwtToken = authHeader.substring(7);
            userEmail = jwtUtils.extractUserName(jwtToken);

            if(userEmail !=null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails userDetails = cachingUserDetailsService.loadUserByUsername(userEmail);
                if(jwtUtils.isTokenValid(jwtToken, userDetails)){
                    SecurityContext context = SecurityContextHolder.createEmptyContext();
                    UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, null,userDetails.getAuthorities());
                    token.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    context.setAuthentication(token);
                    SecurityContextHolder.setContext(context);
                }
            }
            filterChain.doFilter(request, response);
        }

    }

}
