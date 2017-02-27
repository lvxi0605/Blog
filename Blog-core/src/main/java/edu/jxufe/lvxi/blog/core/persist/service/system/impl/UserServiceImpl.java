package edu.jxufe.lvxi.blog.core.persist.service.system.impl;

import edu.jxufe.lvxi.blog.core.persist.entity.system.UserAuthEntity;
import edu.jxufe.lvxi.blog.core.persist.dao.system.UserAuthDao;
import edu.jxufe.lvxi.blog.core.persist.dao.system.UserDao;
import edu.jxufe.lvxi.blog.core.persist.entity.system.UserEntity;
import edu.jxufe.lvxi.blog.core.persist.service.system.UserService;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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


    @Transactional
    public UserAuthEntity register(UserAuthEntity userAuthEntity) {
        userAuthDao.save(userAuthEntity);
        return userAuthEntity;
    }
    @Transactional(readOnly = true)
    public UserAuthEntity findUserAuthByAccount(String account) {
        return userAuthDao.findUserAuthByAccount(account);
    }

    public UserEntity findUserByAccount(String account) {
        return userDao.findUserByAccount(account);
    }
}
