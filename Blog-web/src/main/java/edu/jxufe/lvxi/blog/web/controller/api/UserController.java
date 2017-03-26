/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.controller.api;

import edu.jxufe.lvxi.blog.core.persist.service.system.UserService;
import edu.jxufe.lvxi.blog.web.util.message.MessageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lvxi on 2017/3/8.
 * Note:
 */
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping(value = "isExistAccount",method = RequestMethod.GET)
    public @ResponseBody Object  isExistAccount(@RequestParam("account") String account){
        if(!userService.isExistUser(account)) return  MessageUtils.failure();
        else return MessageUtils.success();
    }
}
