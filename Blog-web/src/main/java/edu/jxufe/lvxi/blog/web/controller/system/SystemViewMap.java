/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.controller.system;

/**
 * Created by lvxi on 2017/2/19.
 */
public interface SystemViewMap {
    String SYSTEM="system";
    //角色管理
    String ROLE=SYSTEM+"/role";
    String ROLE_ADD=ROLE+"/addRole";
    //资源关联
    String RESOURCE=SYSTEM+"/resource";
    String RESOURCE_ADD=RESOURCE+"/addResource";
    //管理员界面
    String ADMIN=SYSTEM+"/admin";
}
