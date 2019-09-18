package com.alessandro.computershare.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DaoLoggingAspect {

  private static Logger logger = LoggerFactory.getLogger(DaoLoggingAspect.class);

  @Before("com.alessandro.computershare.aspect.AopExpressions.servicesAndDaoLogger()")
  public void daoLogger(JoinPoint joinPoint) {
    MethodSignature signature = (MethodSignature) joinPoint.getSignature();
    var args = joinPoint.getArgs();
    logger.debug("AOP - Method invoked {}, with args {}", signature.toShortString(), args);
  }

  @AfterThrowing(
      pointcut = "com.alessandro.computershare.aspect.AopExpressions.daoLoggingAspect()",
      throwing = "exception")
  public void afterThrowingAdviceDao(JoinPoint joinPoint, Throwable exception) {
    var method = joinPoint.getSignature();
    var clazz = method.getDeclaringType();
    logger.error("AOP - Exception thrown after executing {}, in class {}", method.toShortString(), clazz.getSimpleName());
    logger.error("AOP - Error thrown ", exception);
  }
}
