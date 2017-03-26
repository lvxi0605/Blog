/*******************************************************************************
 * (c) Copyright 2017 lvxi. All Rights Reserved.
 ******************************************************************************/

package edu.jxufe.lvxi.blog.core.persist.dao.system;

import edu.jxufe.lvxi.blog.core.persist.dao.base.BaseDao;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserExtendEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by lvxi on 2017/3/9.
 * Note:
 */
@Repository
public class UserExtendDao extends BaseDao<UserExtendEntity> {

    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * 保存用户扩展信息
     * @param userExtendEntity
     * @return 对象ID
     */
    public Serializable save(UserExtendEntity userExtendEntity) {
        return super.save(userExtendEntity);
    }
}
