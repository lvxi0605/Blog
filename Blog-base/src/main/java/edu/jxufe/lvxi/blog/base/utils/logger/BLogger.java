package edu.jxufe.lvxi.blog.base.utils.logger;

import org.apache.log4j.Logger;

/**
 * Created by lvxi on 2017/2/4.
 */
public class BLogger {
    private static char spilt='-';
    private static int spiltNum=50;
    private static String spiltStr="";
    private static String proStr="";
    private static int proNum=5;
    public Logger logger;
    static {
        for (int i=0;i<spiltNum;i++){
            spiltStr+=spilt;
        }
        for (int i=0;i<proNum;i++){
            proStr+=spilt;
        }
    }

    public BLogger(Class clazz){
        logger = Logger.getLogger(clazz);
    }

    public void spiltLine(){
        logger.debug(spiltStr);
    }
    public void spiltLine(Object message){
        StringBuilder temp = new StringBuilder(proStr);
        temp.append(message.toString());
        temp.append(spiltStr);
        logger.debug(temp);
    }
    public void spiltLineMethord(){
        StackTraceElement[] temp=Thread.currentThread().getStackTrace();
        StackTraceElement a=(StackTraceElement)temp[2];
        StringBuilder tempStr = new StringBuilder(proStr);
        tempStr.append(a.getMethodName());
        tempStr.append(spiltStr);
        logger.debug(tempStr);
    }

    public void debug(Object message){
        logger.debug(message);
    }

    public void info(Object message){
        logger.info(message);
    }





}
