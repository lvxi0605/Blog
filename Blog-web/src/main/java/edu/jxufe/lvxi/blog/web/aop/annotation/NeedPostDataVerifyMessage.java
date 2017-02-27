package edu.jxufe.lvxi.blog.web.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by lvxi on 2017/2/16.
 */

/**
 * controller用的注解，用于验证用户输入的数据是否正确，结合hibernate注解使用
 */
@Retention(RetentionPolicy.RUNTIME )
@Target(ElementType.METHOD)
public @interface NeedPostDataVerifyMessage {
    boolean errorStop() default true; //遇到错误，不执行controller中的代码
}
