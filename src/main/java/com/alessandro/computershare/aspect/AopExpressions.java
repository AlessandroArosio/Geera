package com.alessandro.computershare.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AopExpressions {

  /**
   * Pointcut to log every method call in the DAO package
   */
  @Pointcut("execution(* com.alessandro.computershare.database.dao.*.*(..)))")
  public void daoLoggingAspect() {}

  @Pointcut("execution(* com.alessandro.computershare.database.service.*.*(..)))")
  public void servicesLogger() {}

  @Pointcut("daoLoggingAspect() || servicesLogger()")
  public void servicesAndDaoLogger() {}
}
