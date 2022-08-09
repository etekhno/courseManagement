package com.learning.app.config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAOP {

    Logger _logger = LoggerFactory.getLogger(LoggingAOP.class);

    @Around("@annotation(org.springframework.web.bind.annotation.GetMapping) ||" +
            " @annotation(org.springframework.web.bind.annotation.PostMapping) || " +
            " @annotation(org.springframework.web.bind.annotation.DeleteMapping) || " +
            " @annotation(org.springframework.web.bind.annotation.PutMapping) || " +
            " @annotation(org.springframework.web.bind.annotation.PatchMapping) " )
    public Object processLog(ProceedingJoinPoint pjp) throws Throwable {

        _logger.info("before request proceed");
        Object object = pjp.proceed();
        _logger.info("come back the request");

        return object;
    }

}
