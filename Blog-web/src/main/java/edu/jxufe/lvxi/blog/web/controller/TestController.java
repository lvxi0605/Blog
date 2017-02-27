/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lvxi on 2017/2/6.
 */
@Controller
public class TestController extends BaseController{
    @RequestMapping("test")
    public String index(){
        return ViewMap.TEST;
    }
    @RequestMapping("lx")
    public ModelAndView v(){
        ModelAndView md = new ModelAndView("lx");
        md.addObject("signal","just do it!");
        return md;
    }


}
