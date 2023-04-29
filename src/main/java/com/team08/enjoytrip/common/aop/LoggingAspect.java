package com.team08.enjoytrip.common.aop;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

@Component
@Aspect
public class LoggingAspect {
    private Logger logger = LoggerFactory.getLogger(LoggingAspect.class);

    // TODO: TripRoute, Feed Read Write Time Check
    @Around(value = "execution(* com.team08.enjoytrip.tripRoute.controller.TripRouteController.*(..))")
    public Object executionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        logger.debug("around call method : {} ", joinPoint.getSignature());
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        Object proceed = joinPoint.proceed();

        stopWatch.stop();

        logger.debug("summary : {}", stopWatch.shortSummary());
        logger.debug("totalTime : {}", stopWatch.getTotalTimeMillis());
        logger.debug("pretty : {}", stopWatch.prettyPrint());

        return proceed;
    }

}
