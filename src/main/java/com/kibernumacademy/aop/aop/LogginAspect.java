package com.kibernumacademy.aop.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
  // Instancia de Logger para registrar mensajes relaacionados con este aspecto
  private static final Logger logger = LoggerFactory.getLogger(LogginAspect.class);
  //PointCut Define dónde se aplica un aspecto. Es una expresión que identifica métodos o clases específicos (por ejemplo, “todos los métodos en el paquete service”).
  @Pointcut("execution(* com.kibernumacademy.aop.service.*.*(..))")
  public void serviceLayer(){}

  // Advice Es el bloque de código que se ejecuta en momentos específicos durante la ejecución de la aplicación

  // Join Point (Punto de unión): Es un momento específico en la ejecución de un programa donde se puede aplicar un aspecto.
  
  @Before("serviceLayer()")
  public void logBefore(JoinPoint joinPoint) {
    // Registra el nombre del método que se está invocando
    logger.info("Invocando método: {}", joinPoint.getSignature().getName());
  }

  // el AlfterReturning (Después de un método)
  @AfterReturning(pointcut = "serviceLayer()", returning = "result")
  public void logAfterReturning(JoinPoint joinPoint, Object result) {
    // Regitrar el nombre del método y el resultado devuelto
    logger.info("Método {} ejecutado exitosamente. Resultado {}", joinPoint.getSignature().getName(), result);
  }
}
