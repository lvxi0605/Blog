package edu.jxufe.lvxi.blog.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lvxi on 2017/2/6.
 */
@Controller
public class IndexController extends BaseController{
    @RequestMapping("")
    public String index(){
        System.out.println("访问首页");
        return ViewMap.INDEX;
    }


}
