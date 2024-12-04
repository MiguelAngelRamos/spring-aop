package com.kibernumacademy.aop.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ExecutionTimeAspect {
   // Instancia de Logger para registrar mensajes relacionados con este aspecto
  private static final Logger logger = LoggerFactory.getLogger( ExecutionTimeAspect.class);

  // Advice Around se ejecuta antes y despues de la ejecución del metodo especificado

  @Around("execution(* com.kibernumacademy.aop.service.UserService.addUser(..))")
  public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable{
    
    long startTime = System.currentTimeMillis();
    Object result = joinPoint.proceed();
    long endTime = System.currentTimeMillis();

    logger.info("Método: {} ejecutado en {} ms", joinPoint.getSignature().getName(), (endTime-startTime));
    return result;
  }


}

/* Weaving (Entretejido):

Es el proceso de vincular aspectos con el código objetivo en tiempo de compilación, carga o ejecución. */
