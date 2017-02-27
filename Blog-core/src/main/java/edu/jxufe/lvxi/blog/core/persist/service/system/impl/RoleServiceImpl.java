package edu.jxufe.lvxi.blog.core.persist.service.system.impl;

import edu.jxufe.lvxi.blog.core.persist.dao.system.RoleDao;
import edu.jxufe.lvxi.blog.core.persist.entity.system.RoleEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.RoleService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by lvxi on 2017/2/5.
 */
@Service
public class RoleServiceImpl implements RoleService {
    private Logger logger = Logger.getLogger(RoleServiceImpl.class);

    @Autowired
    RoleDao roleDao;

    /**
     * 添加一个角色
     * @param roleEntity 角色
     * @param userEntity 创建人
     * @return
     */
    @Transactional
    public RoleEntity addRole(RoleEntity roleEntity, UserEntity userEntity) {
        roleEntity.setCreaterUser(userEntity);
        roleDao.save(roleEntity);
        return roleEntity;
    }


}
