package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Cntrl {
    Logger logger = LoggerFactory.getLogger(Cntrl.class);


    @RequestMapping("/")
    public String get(){
        logger.debug("Debug log message get");
        logger.info("Info log message get");
        logger.error("Error log message");
        logger.warn("Warn log message");
        logger.trace("Trace log message");
        return "/home /get";
    }
}
