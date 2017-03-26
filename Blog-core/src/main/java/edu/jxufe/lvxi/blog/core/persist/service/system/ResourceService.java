/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.core.persist.service.system;

import edu.jxufe.lvxi.blog.core.persist.entity.system.ResourceEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;

/**
 * Created by lvxi on 2017/2/9.
 */
public interface ResourceService {
    /**
     * 添加一个系统资源
     * @param resourceEntity
     * @param userEntity
     * @return
     */
    ResourceEntity addResource(ResourceEntity resourceEntity, UserEntity userEntity);

}
