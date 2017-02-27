package edu.jxufe.lvxi.blog.web.aop.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Created by lvxi on 2017/2/5.
 */
@Component
@Aspect
public class LoggerAspect implements Ordered {
    private Logger logger = Logger.getLogger(getClass());

    final private static String LINE_SPIRT="----------------------------------------------------------------";

    /**
     *在方法前后打印日志，调用耗时
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("execution(* edu.jxufe.lvxi..*(..)) && !execution(* edu.jxufe.lvxi.blog.web.interceptor.RequestInterceptor..*(..))")
    public Object logAround(ProceedingJoinPoint pjp) throws Throwable {
        StopWatch stopWatch =null;
        String className =null;
        String methodName = null;
        boolean isDebugEnabled = logger.isDebugEnabled();
        if(isDebugEnabled){
            className = pjp.getTarget().getClass().getSimpleName();
            methodName = pjp.getSignature().getName();

            System.out.println();
            StringBuilder proTip = new StringBuilder("---BEG------");
            proTip.append(className);
            proTip.append("--->>>>>>---");
            proTip.append(methodName);
            proTip.append(LINE_SPIRT);
            logger.debug(proTip.toString());
            proTip=null;
            stopWatch = new StopWatch();
            stopWatch.start();
        }

        Object retValue = pjp.proceed();

        if(isDebugEnabled) {

            stopWatch.stop();

            StringBuilder timeTip = new StringBuilder("用时: ");
            timeTip.append(stopWatch.getTotalTimeMillis());
            timeTip.append(" ms");
            logger.debug(timeTip.toString());

            StringBuilder postTip = new StringBuilder("---END------");
            postTip.append(className);
            postTip.append("---<<<<<<---");
            postTip.append(methodName);
            postTip.append(LINE_SPIRT);
            logger.debug(postTip.toString());
            postTip = null;
            System.out.println();
        }
        return retValue;
    }




    public int getOrder() {
        return 0;
    }
}
