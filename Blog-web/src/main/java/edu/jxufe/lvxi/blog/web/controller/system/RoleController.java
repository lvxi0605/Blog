package edu.jxufe.lvxi.blog.web.controller.system;

import edu.jxufe.lvxi.blog.web.controller.BaseController;
import edu.jxufe.lvxi.blog.core.persist.entity.system.RoleEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by lvxi on 2017/2/7.
 */
@Controller
@RequestMapping("/system/role")
public class RoleController extends BaseController {
    private Logger logger = Logger.getLogger(RoleController.class);
    final static String ROLE_ROOT_URL="/system/role/";
    final static String ROLE_ADD_ROLE_URL=ROLE_ROOT_URL+"addRole"; //新建角色地址
    @Autowired
    private RoleService roleService;

    @RequestMapping(value = "/addRole",method = RequestMethod.GET)
    public String addRole(){
        logger.debug("新建角色页面");
        return ROLE_ADD_ROLE_URL;
    }

    @RequestMapping(value = "/addRole",method = RequestMethod.POST)
    public String addRoleCheck(@Valid RoleEntity roleEntity, BindingResult bindingResult, HttpSession session){
        logger.debug("新建角色 -> "+roleEntity.getName());
        if(bindingResult.hasErrors()) {
            bindingResult.getAllErrors();
            logger.debug("新建角色 -> 后台数据校验错误"+bindingResult.getErrorCount());
            return ROLE_ADD_ROLE_URL;
        }
        roleService.addRole(roleEntity,getCurrentUserProfile());
        return "index";
    }

    /**
     * 关联
     * @return
     */
    public String associateRolePage(){
        return "";
    }

}
