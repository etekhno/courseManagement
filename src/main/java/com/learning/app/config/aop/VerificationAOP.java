package com.learning.app.config.aop;

import com.learning.app.services.common.IAuthService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class VerificationAOP {

    @Autowired
    IAuthService authService;

    @Around("@annotation(com.learning.app.controller.annotation.Verification)")
    public void processAuth(ProceedingJoinPoint pjp) throws Throwable {
        boolean validate = authService.isStudentUser();

        if(validate==false)
            throw new IllegalArgumentException("");

        pjp.proceed();
    }

}
