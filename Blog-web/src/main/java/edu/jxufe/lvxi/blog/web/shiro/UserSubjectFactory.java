package edu.jxufe.lvxi.blog.web.shiro;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.UserService;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.subject.SubjectContext;
import org.apache.shiro.web.mgt.DefaultWebSubjectFactory;
import org.apache.shiro.web.subject.support.WebDelegatingSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * Created by lvxi on 2017/2/12.
 */
public class UserSubjectFactory extends DefaultWebSubjectFactory {

    @Autowired
    UserService userService;
    public Subject createSubject(SubjectContext subjectContext) {
        Subject subject = super.createSubject(subjectContext);
        if(subject instanceof WebDelegatingSubject){
            String account = (String) subject.getPrincipal();
            if(StringUtils.hasText(account)){
                UserEntity userEntity = userService.findUserByAccount(account);
                UserSubject userSubject =new UserSubject((WebDelegatingSubject)subject,subjectContext.isSessionCreationEnabled(),userEntity);
                Session session = subjectContext.getSession();
                if(userEntity!=null && session!=null) {
                    session.setAttribute("userProfile",userEntity);
                    return userSubject;
                }

            }
        }
        return subject;
    }

}
