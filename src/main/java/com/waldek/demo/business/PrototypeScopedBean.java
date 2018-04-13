package com.waldek.demo.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;


@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
@Component
public class PrototypeScopedBean {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final AtomicInteger counter = new AtomicInteger();
    public PrototypeScopedBean(){
        log.info("enter constructor");
    }

    public int incrementValue() {
        log.info("increment value -current value is " +  counter.get());
        return counter.incrementAndGet();
    }

}
