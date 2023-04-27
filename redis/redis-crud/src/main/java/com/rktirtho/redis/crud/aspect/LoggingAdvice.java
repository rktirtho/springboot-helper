package com.rktirtho.redis.crud.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAdvice {

    Logger logger = LoggerFactory.getLogger(LoggingAdvice.class);

    //any return type, any class, any method, any number of param
    @Pointcut(value = "execution(* com.rktirtho.redis.crud.repository.*.*(..))")
    public void myPointCut() {
    }

    @Around("myPointCut()")
    public Object applicationLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        ObjectMapper objectMapper = new ObjectMapper();
        var methodName = proceedingJoinPoint.getSignature().getName();
        var className = proceedingJoinPoint.getTarget().getClass().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        logger.info("invoke {}.{}({})"
                , className, methodName, objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(args));

        Object o = proceedingJoinPoint.proceed();
        logger.info("response {}.{} \n {}"
                , className, methodName, objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o));

        return o;

    }
}
