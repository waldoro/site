package com.waldek.demo.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class StatsController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(value="/stats", method = RequestMethod.POST)
    public void receiveStats(HttpServletRequest request) {
        log.info("received statistics");
    }

}
