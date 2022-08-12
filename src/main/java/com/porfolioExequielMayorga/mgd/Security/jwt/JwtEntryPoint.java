/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.porfolioExequielMayorga.mgd.Security.jwt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 *
 * @author usuario
 */
@Component
public class JwtEntryPoint implements AuthenticationEntryPoint {
    private final static Logger logger = LoggerFactory.getLogger(JwtEntryPoint.class);

    // compueba si funciona el metodo commence
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        logger.error("fallo el metodo commence");
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }
}
