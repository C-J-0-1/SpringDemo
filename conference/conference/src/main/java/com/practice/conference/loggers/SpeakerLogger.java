package com.practice.conference.loggers;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class SpeakerLogger {

    @Before("execution(* com.practice.conference.controllers.SpeakersController.*(..))")
    public void logBeforeSpeaker(JoinPoint jp){
        System.out.print("Speaker Controller.");
        System.out.println(jp.getSignature().getName() + "() is Called.");
    }

    @Around("execution(* com.practice.conference.controllers.SpeakersController.*(..))")
    public Object logAroundSpeaker(ProceedingJoinPoint pjp) throws Throwable {
        System.out.print("Speaker Controller.");
        System.out.println(pjp.getSignature().getName() + "() is getting started.");
        Object result = pjp.proceed();
        System.out.println(pjp.getSignature().getName() + "() ended.");
        return result;
    }

    @After("execution(* com.practice.conference.controllers.SpeakersController.*(..))")
    public void logAfterSpeaker(JoinPoint jp){
        System.out.print("Speaker Controller.");
        System.out.println(jp.getSignature().getName() + "()'s Execution is complete.");
    }
}
