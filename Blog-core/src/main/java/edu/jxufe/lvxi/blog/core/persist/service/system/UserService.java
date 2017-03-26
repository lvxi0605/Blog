package edu.jxufe.lvxi.blog.core.persist.service.system;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserAuthEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;

/**
 * Created by lvxi on 2017/2/5.
 */
public interface UserService {
     UserAuthEntity register(UserAuthEntity userAuthEntity);
     UserAuthEntity findUserAuthByAccount(String account);
     UserEntity findUserByAccount(String account);
     boolean isExistUser(String account);
}
