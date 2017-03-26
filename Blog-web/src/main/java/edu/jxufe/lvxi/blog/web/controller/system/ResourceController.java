/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.controller.system;

import edu.jxufe.lvxi.blog.web.controller.BaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lvxi on 2017/3/9.
 * Note:
 */
@Controller
@RequestMapping("/system/resource")
public class ResourceController extends BaseController {
    private Logger logger = Logger.getLogger(this.getClass());

    @RequestMapping(value = "/addResource",method = RequestMethod.GET)
    public String addResourceView(){
        logger.debug("新建资源页面");
        return SystemViewMap.RESOURCE_ADD;
    }
}
