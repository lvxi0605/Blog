/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.util.message;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lvxi on 2017/3/9.
 * Note:
 */
public class Message {
    public String code; //消息code
    public boolean success; //标示成功
    public Object data; //携带的数据
    public List<Object> tips =new LinkedList<Object>(); //提示消息
    public Message() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public List<Object> getTips() {
        return tips;
    }

    public void setTips(List<Object> tips) {
        this.tips = tips;
    }
    public Message addTip(Object tip){
        this.tips.add(tip);
        return this;//链式调用
    }
}