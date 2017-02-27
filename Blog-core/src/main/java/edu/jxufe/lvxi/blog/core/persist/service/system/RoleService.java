package edu.jxufe.lvxi.blog.core.persist.service.system;

import edu.jxufe.lvxi.blog.core.persist.entity.system.RoleEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;

/**
 * Created by lvxi on 2017/2/9.
 */
public interface RoleService {
    RoleEntity addRole(RoleEntity roleEntity, UserEntity userEntity);
}
