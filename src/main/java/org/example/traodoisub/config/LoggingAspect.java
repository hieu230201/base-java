package org.example.traodoisub.config;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.reflect.MethodSignature;
import org.example.traodoisub.logging.LogManage;
import org.example.traodoisub.logging.bases.ILogManage;
import org.springframework.util.StopWatch;

/*@Aspect
@Component*/
public class LoggingAspect {
    private static final ILogManage logger = LogManage.getLogManage(LoggingAspect.class);

    @Around("execution(public * com.mbbank.cmv.service..*(..)))")
    public Object profileAllMethods(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();
        String className = methodSignature.getDeclaringType().getSimpleName();
        String methodName = methodSignature.getName();
        final StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        Object result = proceedingJoinPoint.proceed();
        stopWatch.stop();
        if (stopWatch.getTotalTimeMillis() > 10000)
            logger.info("Method Execution long time of " + className + "." + methodName + " :: " + stopWatch.getTotalTimeMillis()
                    + " ms");

        return result;
    }
}
