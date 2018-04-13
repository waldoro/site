package com.waldek.demo.controllers;

import com.waldek.demo.business.PrototypeScopedBean;
import com.waldek.demo.business.RequestScopedClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Enumeration;
import java.util.Map;

/**
 * Created by wrokita on 17/01/2017.
 */
@RestController
public class HelloController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private RequestScopedClass rsc;

    @Autowired
    private PrototypeScopedBean psb;

    public HelloController() {
        log.info("enter constructor");
    }

    @RequestMapping(value="/hello")
    public String hello(){
        return "Hello";
    }

    @RequestMapping(value="/hoho", method = RequestMethod.GET)
    public void test(HttpServletRequest req) throws IOException {
        Enumeration<String> sessionAttributes = req.getSession().getAttributeNames();
        log.info("logged user name " + SecurityContextHolder.getContext().getAuthentication().getName());
        while (sessionAttributes.hasMoreElements()){
            log.info("session attribute name " + sessionAttributes.nextElement());
        }
        log.info("Entering test method in controller. counter value: "+ rsc.incrementCounter());
        log.info("value from prototype bean:" + psb.incrementValue());
        //logA(req.getAttributeNames(), req);
        //log(req.getParameterMap());
        //logH(req.getHeaderNames(), req);
        //log.info(req.toString());
        ///log.info(convertInputStream(req.getInputStream()));
    }

    private void log(Map<String, String[]> parameterMap) {
        for(String key:parameterMap.keySet()) {
            log.info(key + " - " + parameterMap.get(key));
        }
    }

    private void logA(Enumeration<String> attributeNames, HttpServletRequest request) {
        while (attributeNames.hasMoreElements()){
            String attribute = attributeNames.nextElement();
            log.info(attribute + " - " + request.getAttribute(attribute));
        }
    }
    private void logH(Enumeration<String> attributeNames, HttpServletRequest request) {
        while (attributeNames.hasMoreElements()){
            String attribute = attributeNames.nextElement();
            log.info(attribute + " - " + request.getHeader(attribute));
        }
    }

    private String convertInputStream (InputStream is) {
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line;
        try {
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
        }catch(Exception e){
            log.error("Some error occurred", e);
        }
        return sb.toString();
    }
}

