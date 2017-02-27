package edu.jxufe.lvxi.blog.web.shiro;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import org.apache.shiro.web.subject.support.WebDelegatingSubject;

/**
 * Created by lvxi on 2017/2/12.
 */
public class UserSubject extends WebDelegatingSubject {
    private UserEntity userEntity;

    public UserSubject(WebDelegatingSubject subject,  boolean sessionEnabled,UserEntity userEntity) {
        super(subject.getPrincipals(), subject.isAuthenticated(), subject.getHost(), subject.getSession(), sessionEnabled , subject.getServletRequest(), subject.getServletResponse(), subject.getSecurityManager());
        this.userEntity = userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
