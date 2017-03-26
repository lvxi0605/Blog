/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.core.persist.dao.system;

import edu.jxufe.lvxi.blog.core.persist.dao.base.BaseDao;
import edu.jxufe.lvxi.blog.core.persist.entity.system.ResourceEntity;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by lvxi on 2017/3/9.
 * Note:
 */
@Repository
public class ResourceDao extends BaseDao <ResourceEntity>{
    /**
     * 保存资源
     * @param resourceEntity
     * @return 对象ID
     */
    public Serializable save(ResourceEntity resourceEntity) {
        return super.save(resourceEntity);
    }

}
