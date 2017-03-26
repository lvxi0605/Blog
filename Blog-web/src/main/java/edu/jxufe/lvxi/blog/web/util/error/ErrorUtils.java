/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.util.error;

import org.apache.commons.collections.map.LinkedMap;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by lvxi on 2017/3/18.
 * Note:
 */
public class ErrorUtils {
    private final static String ATTR_KEY="errorMap";
    private final static String DEFAULT_FIELD_KEY="defalut";
    //private static final ThreadLocal<Boolean> isExist= new ThreadLocal<Boolean>();
    /**
     * 是否在request中
     * @return
     */
    private static boolean isExistRequest(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return  request.getAttribute(ATTR_KEY)==null?false:true;
    }
    private static void init(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Map<String,Object> errorMap = new LinkedMap();
        request.setAttribute(ATTR_KEY,errorMap);
    }
    public static  Map<String,Object> getErrorMap(){
        if(!isExistRequest()){
            init();
        }
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        return (Map<String, Object>) request.getAttribute(ATTR_KEY);

    }
    public static void addError(Object mssage){
        Map<String,Object> errorMap = getErrorMap();
        errorMap.put(DEFAULT_FIELD_KEY,mssage);
    }
    public static void addError(String key, Object mssage){
        Map<String,Object> errorMap = getErrorMap();
        errorMap.put(key,mssage);
    }
    public static void removeError(){
        Map<String,Object> errorMap = getErrorMap();
        errorMap.remove(DEFAULT_FIELD_KEY);
    }
    public static void removeError(String key){
        Map<String,Object> errorMap = getErrorMap();
        errorMap.remove(key);
    }
    public static String toStringMessage(){
        StringBuilder msg = new StringBuilder();
        Map<String,Object> errorMap = getErrorMap();
        if(!errorMap.isEmpty()){
            Set<Map.Entry<String,Object>> set = errorMap.entrySet();
            Iterator<Map.Entry<String,Object>> it = set.iterator();
            int errorCount =0;
            if (it.hasNext()){
                Map.Entry<String,Object> entry = it.next();
                errorCount++;
                Object mssage = entry.getValue();
                msg.append(errorCount);
                msg.append('.');
                msg.append(mssage);
                msg.append("。");
            }
        }
        return msg.toString();
    }
}
