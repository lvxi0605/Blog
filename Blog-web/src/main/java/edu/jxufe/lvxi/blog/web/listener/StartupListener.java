/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.web.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by lvxi on 2017/3/19.
 * Note:
 */
public class StartupListener implements ServletContextListener {

    /**
     * 容器启动
     * @param servletContextEvent
     */
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("容器启动");
        ServletContext servletContext =servletContextEvent.getServletContext();
        String contextPath = servletContext.getContextPath();
        System.out.println("ContextPath => "+contextPath);
        servletContext.setAttribute("ctx",contextPath);
    }

    /**
     * 容器关闭
     * @param servletContextEvent
     */
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("容器关闭");
    }
}
