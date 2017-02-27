package edu.jxufe.lvxi.blog.web.exception;

import com.alibaba.fastjson.JSON;
import edu.jxufe.lvxi.blog.base.data.Data;
import org.apache.log4j.Logger;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lvxi on 2017/2/18.
 */
@Component
public class SystemExceptionResolver implements HandlerExceptionResolver {
    private Logger logger = Logger.getLogger(getClass());

    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        if (logger.isDebugEnabled()) {
            logger.error("捕获到异常", ex);
        } else {
            logger.error("捕获到异常");
        }
        String message = ex.getMessage();
        if (isAjax(handler)) {
            //该请求为ajax方式
            response.setContentType("application/json;charset=utf-8");
            try {
                response.getWriter().print(JSON.toJSONString(Data.failure(message)));
                response.getWriter().flush();
                response.getWriter().close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            //1重新刷新页面并显示信息
            //2跳转到错误页面显示
        }


        return null;
    }

    /**
     * 判断是否 ajax 调用
     *
     * @param handler
     * @return
     */
    private boolean isAjax(Object handler) {
        if (handler != null && handler instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            ResponseBody responseBodyAnn = AnnotationUtils.findAnnotation(handlerMethod.getMethod(), ResponseBody.class);
            return responseBodyAnn != null;
        }

        return false;
    }

}
