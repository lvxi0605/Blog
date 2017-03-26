/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import edu.jxufe.lvxi.blog.web.tag.Column;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lvxi on 2017/2/6.
 */
@Controller
public class TestController extends BaseController{
    private Logger logger = Logger.getLogger(getClass());
    @RequestMapping("test")
    public String index(){
        return IndexViewMap.TEST;
    }
    @RequestMapping("less")
    public String less(){
        return "less";
    }
    @RequestMapping("lx")
    public ModelAndView v(){
        ModelAndView md = new ModelAndView("lx");
        md.addObject("signal","just do it!");
        return md;
    }
    @RequestMapping("test/json")
    @ResponseBody
    public Object json(){
        JSONObject obj = new JSONObject();
        Column col1 =new Column();
        col1.setField("account");
        col1.setTitle("账号");
        Column col2 =new Column();
        col2.setField("nickname");
        col2.setTitle("昵称");
        JSONArray cols = new JSONArray();
        cols.add(col1);
        cols.add(col2);
        obj.put("columns",cols);

        List<UserEntity> list = new LinkedList<UserEntity>();
        for (int i=0;i<10;i++){
            UserEntity  userEntity = new UserEntity();
            userEntity.setAccount("test"+i);
            userEntity.setNickname("Just do it"+i);
            list.add(userEntity);
        }
        obj.put("data",list);
        obj.put("currPage","1");
        obj.put("totalPages","1");
        obj.put("totalRecords","100");
        logger.info(obj.toJSONString());
        return obj;

    }

}
