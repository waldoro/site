package com.waldek.demo.business;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.concurrent.atomic.AtomicInteger;

@RequestScope
@Component
public class RequestScopedClass {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private AtomicInteger counter = new AtomicInteger();

    public RequestScopedClass(){
        log.info("Constructor called");
    }

    public int incrementCounter() {
        log.info("Enter increment - current value: " + counter.get());
        return counter.incrementAndGet();
    }
}
