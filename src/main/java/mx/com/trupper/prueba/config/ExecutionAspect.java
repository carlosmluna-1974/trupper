package mx.com.trupper.prueba.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Around;
import org.springframework.stereotype.Component;

import lombok.extern.log4j.Log4j2;

@Aspect
@Component
@Log4j2
public class ExecutionAspect {

    @Around("execution(* mx.com.trupper.prueba.service..*(..))")
    public Object medirTiempoEjecucion(ProceedingJoinPoint joinPoint) throws Throwable {
        long inicio = System.currentTimeMillis();

        Object resultado = joinPoint.proceed();

        long fin = System.currentTimeMillis();
        long duracion = fin - inicio;

        String nombreMetodo = joinPoint.getSignature().toShortString();
        log.info("Ejecución de {} tomó {} ms", nombreMetodo, duracion);

        return resultado;
    }

}
