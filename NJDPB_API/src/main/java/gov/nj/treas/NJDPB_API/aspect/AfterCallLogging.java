package gov.nj.treas.NJDPB_API.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class AfterCallLogging {

    @AfterReturning(pointcut = "@annotation(gov.nj.treas.NJDPB_API.annotation.DebugLogging)", returning = "result")
    public void logResult(JoinPoint joinPoint, Object result){


        String methodName = joinPoint.getSignature().toShortString();
        log.debug("Repository Method {} returned: {}", methodName, result);


    }
}
