/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.controller.system;

import edu.jxufe.lvxi.blog.core.persist.entity.system.RoleEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.RoleService;
import edu.jxufe.lvxi.blog.web.controller.BaseController;
import edu.jxufe.lvxi.blog.web.util.message.Message;
import edu.jxufe.lvxi.blog.web.util.message.MessageUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by lvxi on 2017/2/7.
 */
@Controller
@RequestMapping("/system")
public class AdminController extends BaseController {
    private Logger logger = Logger.getLogger(this.getClass());
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/admin",method = RequestMethod.GET)
    public String adminView(){
        logger.debug("管理页面");
        return SystemViewMap.ADMIN;
    }

    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public @ResponseBody Message addRoleSubmit(@Valid RoleEntity roleEntity, BindingResult bindingResult, HttpSession session){
        //roleService.addRole(roleEntity,getCurrentUserProfile());
        if(roleEntity.getId()==null) MessageUtils.failure("测试错误");
        //TODO 要返回到角色列表
        return MessageUtils.success("测试成功");
    }

    /**
     * 关联
     * @return
     */
    public String associateRolePage(){
        return "";
    }

}
