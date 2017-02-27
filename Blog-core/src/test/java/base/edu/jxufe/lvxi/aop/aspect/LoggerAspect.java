package base.edu.jxufe.lvxi.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by lvxi on 2017/2/5.
 */
@Aspect
public class LoggerAspect {
    private static String spirt="----------------------------------------------------------------";
    @Before("execution(* edu.jxufe.lvxi..*(..))")
    public void beforeMethod(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("\nBEG---"+className+"------>>>>>"+joinPoint.getSignature().getName()+spirt+"\n");
    }
    @After("execution(* edu.jxufe.lvxi..*(..))")
    public void afterMethod(JoinPoint joinPoint){
        String className = joinPoint.getTarget().getClass().getSimpleName();
        System.out.println("\nEND---"+className+"------<<<<<"+joinPoint.getSignature().getName()+spirt+"\n");
    }
}
