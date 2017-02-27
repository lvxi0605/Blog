package edu.jxufe.lvxi.blog.web.shiro;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.util.ByteSource;

/**
 * Created by lvxi on 2017/2/12.
 */
public class UserAuthenticationInfo  extends SimpleAuthenticationInfo {
    private UserEntity userEntity;
    public UserAuthenticationInfo(UserEntity userEntity,Object principal, Object hashedCredentials, ByteSource credentialsSalt, String realmName) {
        super(principal, hashedCredentials, credentialsSalt, realmName);
        this.userEntity =userEntity;
    }

    public UserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(UserEntity userEntity) {
        this.userEntity = userEntity;
    }
}
