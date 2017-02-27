package edu.jxufe.lvxi.blog.core.persist.dao.system;

import edu.jxufe.lvxi.blog.core.persist.dao.base.BaseDao;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by lvxi on 2017/2/4.
 */
@Repository
public class UserDao extends BaseDao<UserEntity> {
    private Logger logger = Logger.getLogger(UserDao.class);

    /**
     * 保存用户
     * @param userEntity
     * @return 对象ID
     */
    public Serializable save(UserEntity userEntity) {
           return super.save(userEntity);
    }

    /***
     * 通过账号查找用户信息
     * @param account
     * @return
     */
    public UserEntity findUserByAccount(String account) {
        String hql = "from UserEntity user where user.account = ?";
        return (UserEntity)uniqueQuery(hql,account);
    }

}
