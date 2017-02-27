package edu.jxufe.lvxi.blog.web.aop.aspect;

import edu.jxufe.lvxi.blog.base.data.Data;
import edu.jxufe.lvxi.blog.web.aop.annotation.NeedPostDataVerifyMessage;
import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by lvxi on 2017/2/16.
 */
@Component
@Aspect
public class DataCheckAspect implements Ordered {
    private Logger logger = Logger.getLogger(getClass());
//    public final static int CHECK_PRO_ERRORS_STOP=0; //检查到错误就返回错误信息，后面错误不管
//    public final static int CHECK_ALL_ERRORS=1; //检查所有错误
//    private int checkMode= CHECK_PRO_ERRORS_STOP; //因为是单实例模式，只会实例化一次，所以没有设置成static

    /**
     * 处理数据校验，异常将消息返回给前台，json格式
     *
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(edu.jxufe.lvxi.blog.web.aop.annotation.NeedPostDataVerifyMessage)")
    public Object poress(ProceedingJoinPoint pjp) throws Throwable {

        Method currentMethod = getCurrentMethod(pjp);
        Object[] args = pjp.getArgs();
        NeedPostDataVerifyMessage dataVerifyMessageAnn = AnnotationUtils.findAnnotation(currentMethod, NeedPostDataVerifyMessage.class);

        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                if (args[i] instanceof BindingResult) {
                    BindingResult bindingResult = (BindingResult) args[i];
                    if (bindingResult.hasErrors()) {
                        List<ObjectError> errors = bindingResult.getAllErrors();
                        StringBuilder message = new StringBuilder();
                        for (int errIndex = 0; errIndex < errors.size(); ) {
                            ObjectError error = errors.get(errIndex);
                            errIndex++;
                            message.append(errIndex);
                            message.append(". ");
                            message.append(error.getDefaultMessage());
                            message.append("\n");
                        }
                        logger.debug("数据校验有误!!!!!");

                        if (isAjax(currentMethod)){
                            return Data.failure(message.toString());
                        }


                    }
                }
            }
        }
        Object retValue=null;
        if(dataVerifyMessageAnn.errorStop()) retValue= pjp.proceed();
        else {
            HttpServletRequest req = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            retValue=req.getRequestURL().toString();
        }

        return retValue;
    }

    /**
     * 通过切点获取当前方法
     * @param pjp
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalArgumentException
     */
    private Method getCurrentMethod(ProceedingJoinPoint pjp) throws NoSuchMethodException, IllegalArgumentException {
        Signature sig = pjp.getSignature();
        MethodSignature msig = null;
        if (!(sig instanceof MethodSignature)) {
            throw new IllegalArgumentException("该注解只能用于方法");
        }
        msig = (MethodSignature) sig;
        Object target = pjp.getTarget();
        Method currentMethod = target.getClass().getMethod(msig.getName(), msig.getParameterTypes());
        return currentMethod;
    }

    /**
     * 增强顺序，越小越优先
     *
     * @return
     */
    public int getOrder() {
        return 1;
    }


    /**
     * 通过注解ResponseBody,判断是否 ajax 调用
     *
     * @param method
     * @return
     */
    private boolean isAjax(Method method) {
        ResponseBody responseBodyAnn = AnnotationUtils.findAnnotation(method, ResponseBody.class);
        return responseBodyAnn != null;
    }
//
//    public  int getCheckMode() {
//        return this.checkMode;
//    }
//
//    public  void setCheckMode(int checkMode) {
//        this.checkMode = checkMode;
//    }
}
