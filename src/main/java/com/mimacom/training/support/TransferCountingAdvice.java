package com.mimacom.training.support;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.stereotype.Component;

/**
 * @author Agim Emruli
 */
@Aspect
@Component
public class TransferCountingAdvice {

    private final CounterService counterService;

    @Autowired
    public TransferCountingAdvice(CounterService counterService) {
        this.counterService = counterService;
    }

    @After("execution(* com.mimacom.training.TransferService+.transfer(..))")
    public void incrementTransfer(JoinPoint joinPoint){
        counterService.increment(joinPoint.getSignature().getName());
    }
}
