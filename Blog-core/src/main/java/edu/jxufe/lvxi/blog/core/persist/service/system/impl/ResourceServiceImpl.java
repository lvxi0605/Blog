/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.core.persist.service.system.impl;

import edu.jxufe.lvxi.blog.core.persist.dao.system.ResourceDao;
import edu.jxufe.lvxi.blog.core.persist.entity.system.ResourceEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

/**
 * Created by lvxi on 2017/3/9.
 * Note:
 */
@Service
public class ResourceServiceImpl implements ResourceService {
    @Autowired
    ResourceDao resourceDao;

    @Transactional
    public ResourceEntity addResource(ResourceEntity resourceEntity, UserEntity userEntity) {
        resourceEntity.setCreaterId(userEntity.getId());
        resourceEntity.setCreatedDate(new Timestamp(System.currentTimeMillis()));
        resourceDao.save(resourceEntity);
        return resourceEntity;
    }
}
