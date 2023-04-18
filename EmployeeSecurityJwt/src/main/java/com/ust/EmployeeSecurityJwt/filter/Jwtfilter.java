package com.ust.EmployeeSecurityJwt.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.ust.EmployeeSecurityJwt.services.UserServices;
import com.ust.EmployeeSecurityJwt.util.Jwtutil;


@Component
public class Jwtfilter extends OncePerRequestFilter {
	@Autowired
	private Jwtutil jwtutil;
	@Autowired
	private UserServices services;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String authorizationHeader =request.getHeader("Autherization");
		String token=null;
		String userName=null;
		
		if(authorizationHeader !=null && authorizationHeader.startsWith("Bearer")) {
            token= authorizationHeader.substring(7);
            userName=jwtutil.extractUsername(token);
        }
        if (userName !=null&& SecurityContextHolder.getContext().getAuthentication()==null) {
            UserDetails userdetails= services.loadUserByUsername(userName);
            if (jwtutil.validateToken(token,userdetails)) {
                
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
                        new UsernamePasswordAuthenticationToken(userdetails,null,userdetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails
                (new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request,response);
    }

	
		
		
		
	}

