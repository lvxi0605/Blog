package edu.jxufe.lvxi.blog.core.persist.service.system.impl;

import edu.jxufe.lvxi.blog.core.persist.dao.system.UserAuthDao;
import edu.jxufe.lvxi.blog.core.persist.dao.system.UserDao;
import edu.jxufe.lvxi.blog.core.persist.dao.system.UserExtendDao;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserAuthEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserExtendEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.UserService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;


/**
 * Created by lvxi on 2017/2/5.
 */
@Service
public class UserServiceImpl implements UserService {
    private Logger logger = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    UserDao userDao;

    @Autowired
    UserAuthDao userAuthDao;

    @Autowired
    UserExtendDao userExtendDao;

    @Transactional
    public UserAuthEntity register(UserAuthEntity userAuthEntity) {

        //保存认证信息
        userAuthDao.save(userAuthEntity);
        UserEntity userEntity = new UserEntity();

        //生成用户信息
        userEntity.setAccount(userAuthEntity.getAccount());
        String nickname = "新用户"+RandomStringUtils.randomAlphanumeric(4);
        userEntity.setNickname(nickname);
        userEntity.setId(userAuthEntity.getId());
        userDao.save(userEntity);

        //生成用户扩展信息
        UserExtendEntity userExtendEntity = new UserExtendEntity();
        userExtendEntity.setId(userAuthEntity.getId());
        userExtendEntity.setRegisterDate(new Timestamp(System.currentTimeMillis()));
        userExtendDao.save(userExtendEntity);


        return userAuthEntity;
    }

    @Transactional(readOnly = true)
    public UserAuthEntity findUserAuthByAccount(String account) {
        return userAuthDao.findUserAuthByAccount(account);
    }

    public UserEntity findUserByAccount(String account) {
        return userDao.findUserByAccount(account);
    }

    public boolean isExistUser(String account) {
        return userAuthDao.isExistUser(account);
    }

}
