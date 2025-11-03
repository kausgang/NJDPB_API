package gov.nj.treas.NJDPB_API.aspect;


import gov.nj.treas.NJDPB_API.annotation.SimulateDelay;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionException;
//
//@Aspect
//@Component
//@RequiredArgsConstructor
//@Slf4j
//public class DelaySimulationAspect {
//
//
//    @Around("@annotation(simulateDelay)")
//    public Object simulateDelayIfEnabled(ProceedingJoinPoint joinPoint, SimulateDelay simulateDelay) throws Throwable {
////        if (featureManager.isActive(MyFeatures.SIMULATE_DB_DELAY)) {
//            long delay = simulateDelay.millis();
////            long delay = 7000;
//            log.info("Simulating delay of {} ms before executing method: {}", delay, joinPoint.getSignature());
//            try {
//                Thread.sleep(delay);
//            } catch (InterruptedException e) {
//                Thread.currentThread().interrupt();
//            }
////        }
//        return joinPoint.proceed();
//    }
//
//}




@Aspect
@Component
@RequiredArgsConstructor
@Slf4j
public class DelaySimulationAspect {

//    private final FeatureManager featureManager;

    @Around("@annotation(simulateDelay)")
    public Object simulateDelayIfEnabled(ProceedingJoinPoint joinPoint, SimulateDelay simulateDelay) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Class<?> returnType = signature.getReturnType();

        if (!CompletableFuture.class.isAssignableFrom(returnType)) {
            // Not a CompletableFuture-returning method, proceed normally
            return joinPoint.proceed();
        }

        return CompletableFuture.supplyAsync(() -> {
            try {
//                if (featureManager.isActive(MyFeatures.SIMULATE_DB_DELAY)) {
                    long delay = simulateDelay.millis();
                    log.info("Simulating delay of {} ms for method {}", delay, joinPoint.getSignature());
                    Thread.sleep(delay);
//                }

                // Proceed with the original method
                return ((CompletableFuture<?>) joinPoint.proceed()).join(); // unwrap inner future
            } catch (Throwable t) {
                throw new CompletionException(t);
            }
        });
    }
}
