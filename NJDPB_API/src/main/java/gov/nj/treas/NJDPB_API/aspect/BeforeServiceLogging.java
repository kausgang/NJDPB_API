package gov.nj.treas.NJDPB_API.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class BeforeServiceLogging {

    @Before("execution(* gov.nj.treas.NJDPB_API.service.impl.*.*(..))")
    public void logMethodName(JoinPoint joinPoint){


        Signature methodName = joinPoint.getSignature();

        log.info("Calling {}",methodName);

    }
}
