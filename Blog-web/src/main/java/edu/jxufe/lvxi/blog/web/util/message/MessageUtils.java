/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.util.message;

/**
 * Created by lvxi on 2017/3/9.
 * Note:
 */
public class MessageUtils {

    public static Message success(){
        Message message = new Message();
        message.setSuccess(true);
        return message;
    }
    public static Message success(Object tip){
        Message message = new Message();
        message.setSuccess(true);
        message.addTip(tip);
        return message;
    }

    public static Message failure(){
        Message message = new Message();
        message.setSuccess(false);
        return message;
    }
    public static Message failure(Object tip) {
        Message message = new Message();
        message.setSuccess(false);
        message.addTip(tip);
        return message;
    }
}
