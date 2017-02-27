package edu.jxufe.lvxi.blog.web.controller;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserAuthEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.UserService;
import edu.jxufe.lvxi.blog.web.util.PasswordUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by lvxi on 2017/2/7.
 */
@Controller
public class LoginController extends BaseController {
    private Logger logger = Logger.getLogger(LoginController.class);
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginView(){
        return ViewMap.LOGIN;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String loginCheck(@Valid UserAuthEntity userAuthEntity, BindingResult bindingResult) {

        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userAuthEntity.getAccount(), userAuthEntity.getPassword());
        String loginError=null;
        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            loginError="用户名密码错误,登录失败!";
        } catch (IncorrectCredentialsException e) {
            loginError="用户名密码错误,登录失败!";
        }catch (LockedAccountException e) {
            loginError="用户名已被锁定,禁止登录!";
        }
        catch (AuthenticationException e) {
            loginError="用户认证失败!";
        }
        if (StringUtils.isNotBlank(loginError)){
            getRequest().setAttribute("loginError",loginError);
            return ViewMap.LOGIN;
        }

        return ViewMap.INDEX;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String regiserCheck(@Valid UserAuthEntity userAuthEntity, BindingResult bindingResult) {
        logger.debug("用户注册" + userAuthEntity.getAccount());
        if (bindingResult.hasErrors()) return "redirect:/html/user/register.html";

        //随机产生32位盐
        String randSalt = RandomStringUtils.randomAlphanumeric(32);
        userAuthEntity.setSalt(randSalt);

        //加密密码
        userAuthEntity.setPassword(PasswordUtils.md5(userAuthEntity.getPassword(), userAuthEntity.getSalt(), 2));
        userService.register(userAuthEntity);

        return "redirect:/html/user/login.jsp";
    }
}