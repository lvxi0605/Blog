package edu.jxufe.lvxi.blog.web.controller;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import edu.jxufe.lvxi.blog.web.shiro.UserSubject;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by lvxi on 2017/2/6.
 */
public class BaseController {

    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletRequest request;

//    @Autowired
//    private HttpServletResponse response;

    /**
     * 获取当前登录人的信息
     * @return
     */
    protected UserEntity getCurrentUserProfile() {
        return getSubject().getUserEntity();
    }

    protected UserSubject getSubject() {
        return ((UserSubject) SecurityUtils.getSubject());
    }

    /**
     * 获取当前登录人的ip
     * @return
     * @throws Exception
     */
    public  String getIpAddr() throws Exception {
        String ip = request.getHeader("X-Real-IP");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            return ip;
        }
        ip = request.getHeader("X-Forwarded-For");
        if (!StringUtils.isBlank(ip) && !"unknown".equalsIgnoreCase(ip)) {
            // 多次反向代理后会有多个IP值，第一个为真实IP。
            int index = ip.indexOf(',');
            if (index != -1) {
                return ip.substring(0, index);
            } else {
                return ip;
            }
        } else {
            return request.getRemoteAddr();
        }
    }


    public String redirect(String url){
        return "redirect:/"+url;
    }
    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public HttpServletRequest getRequest() {
        return request;
    }

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }
}
