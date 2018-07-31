package training.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author Arya Pishgah (pishgah@gamelectronics.com) 23/07/2018
 */
@Aspect
public class TraceAspect {

    private static final Logger LOG = LoggerFactory.getLogger(TraceAspect.class);

    @Around("execution(* training..*(..)) && !within(training..*Test) && !within(training.aspect..*)")
    public Object methodExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        enterMethodTracing(proceedingJoinPoint);
        return exitMethodTracing(proceedingJoinPoint);
    }

    private void enterMethodTracing(JoinPoint joinPoint) {
        Signature methodSignature = joinPoint.getSignature();
        String params = getMethodArguments(joinPoint);
        LOG.trace("Enter method: {}({})", methodSignature.getName(), params);
    }

    private String getMethodArguments(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        return Arrays.stream(args)
                .map(obj -> {
                    if (obj.getClass().isArray()) {
                        if (obj.getClass().getComponentType().isPrimitive())
                            return Arrays.toString((int[]) obj);

                        return Arrays.toString((Object[]) obj);
                    }
                    return obj.toString();
                })
                .collect(Collectors.joining(", "));
    }

    private Object exitMethodTracing(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object returnVal = proceedingJoinPoint.proceed();
        if (returnVal != null)
            LOG.trace("return {}", returnVal);
        else {
            String params = getMethodArguments(proceedingJoinPoint);
            LOG.trace("given param after proceed is {}", params);
        }

        return returnVal;
    }

}
