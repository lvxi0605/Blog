package edu.jxufe.lvxi.blog.web.shiro;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserAuthEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lvxi on 2017/2/7.
 */
public class BlogRealm extends AuthorizingRealm{
    @Autowired
    private UserService userService;

    /**
     * 获取授权信息
     * @param principalCollection
     * @return
     */
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String account = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        authorizationInfo.addRole("root");

        return authorizationInfo;
    }

    /**
     * 获取身份认证信息
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account = (String) authenticationToken.getPrincipal();
        UserAuthEntity userAuthEntity = userService.findUserAuthByAccount(account);
        if(userAuthEntity==null) throw new UnknownAccountException();
        if(userAuthEntity.isLockedAccount()) throw new LockedAccountException();
        UserEntity userEntity = userService.findUserByAccount(account);
        UserAuthenticationInfo authenticationInfo = new UserAuthenticationInfo(
                userEntity,
                account, //用户名
                userAuthEntity.getPassword(), //密码
                ByteSource.Util.bytes(userAuthEntity.getSalt()),
                getName() //realm name
        );
        return authenticationInfo;
    }
}
