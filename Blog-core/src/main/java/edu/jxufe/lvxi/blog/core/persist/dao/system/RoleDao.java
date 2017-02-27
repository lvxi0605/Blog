package edu.jxufe.lvxi.blog.core.persist.dao.system;

import edu.jxufe.lvxi.blog.core.persist.entity.system.RoleEntity;
import edu.jxufe.lvxi.blog.core.persist.dao.base.BaseDao;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by lvxi on 2017/2/9.
 */
@Repository
public class RoleDao  extends BaseDao<RoleEntity> {
    private Logger logger = Logger.getLogger(RoleDao.class);

    /**
     * 保存角色
     * @param roleEntity
     * @return 对象ID
     */
    public Serializable save(RoleEntity roleEntity) {
        return super.save(roleEntity);
    }


}
