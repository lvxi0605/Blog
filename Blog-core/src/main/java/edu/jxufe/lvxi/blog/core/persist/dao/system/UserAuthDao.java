package edu.jxufe.lvxi.blog.core.persist.dao.system;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserAuthEntity;
import edu.jxufe.lvxi.blog.core.persist.dao.base.BaseDao;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * Created by lvxi on 2017/2/4.
 */
@Repository
public class UserAuthDao extends BaseDao<UserAuthEntity> {
    private Logger logger = Logger.getLogger(UserAuthDao.class);

    /**
     * 保存用户认证信息
     * @param userAuthEntity
     * @return 对象ID
     */
    public Serializable save(UserAuthEntity userAuthEntity) {
           return super.save(userAuthEntity);
    }

    /***
     * 通过账号查找用户验证信息
     * @param account
     * @return
     */
    public UserAuthEntity findUserAuthByAccount(String account) {
        String hql = "from UserAuthEntity ua where ua.account = ?";
        return (UserAuthEntity)uniqueQuery(hql,account);
    }

    public boolean isExistUser(String account){
        Assert.assertNotNull(account);
        return (Long)(getSqlSessionTemplate().selectOne("UserAuth.findUserCount",account))>0;
    }


}
