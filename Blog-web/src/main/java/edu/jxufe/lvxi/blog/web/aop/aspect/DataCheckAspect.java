package edu.jxufe.lvxi.blog.web.aop.aspect;

import edu.jxufe.lvxi.blog.web.aop.annotation.UserDataVerify;
import edu.jxufe.lvxi.blog.web.util.error.ErrorUtils;
import edu.jxufe.lvxi.blog.web.util.message.MessageUtils;
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
import org.springframework.validation.FieldError;
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
    @Around("@annotation(edu.jxufe.lvxi.blog.web.aop.annotation.UserDataVerify)")
    public Object poress(ProceedingJoinPoint pjp) throws Throwable {

        Method currentMethod = getCurrentMethod(pjp);
        Object[] args = pjp.getArgs();
        UserDataVerify dataVerifyMessageAnn = AnnotationUtils.findAnnotation(currentMethod, UserDataVerify.class);
        Object retValue=null; //返回的值
        boolean isErrorData=false;
        if (args.length > 1) {
            for (int i = 1; i < args.length; i++) {
                if (args[i] instanceof BindingResult) {
                    BindingResult bindingResult = (BindingResult) args[i];
                    if (bindingResult.hasErrors()) {
                        List<FieldError>  errors = bindingResult.getFieldErrors();
                        for (int errIndex = 0; errIndex < errors.size(); errIndex++) {
                            FieldError error = errors.get(errIndex);
                            ErrorUtils.addError(error.getField(),error.getDefaultMessage());
                            logger.debug(error.getField());
                        }
                        logger.debug("数据校验有误!!!!!");
                        isErrorData=true;
                        break; //不校验其他对象

                    }
                }
            }
            if(isErrorData){
                //有错误的数据
                if(!dataVerifyMessageAnn.errorStop()){
                    retValue= pjp.proceed();
                }
                else {
                    //不执行controller
                    if (isAjax(currentMethod)){
                        return MessageUtils.failure(ErrorUtils.toStringMessage());
                    }
                    else {
                        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                        String errorPage = dataVerifyMessageAnn.errorPage();
                        logger.debug("跳转 => "+errorPage);
                        return errorPage;
                    }

                }
            }else{
                //数据没有错，执行controller
                retValue= pjp.proceed();
            }


        }else{
            //没有数据要校验
            retValue= pjp.proceed();
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
