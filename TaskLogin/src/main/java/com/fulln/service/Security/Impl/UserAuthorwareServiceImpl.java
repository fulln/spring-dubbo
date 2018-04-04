package com.fulln.service.Security.Impl;


import com.fulln.dao.Security.SysLoginDao;
import com.fulln.entity.Security.userEmpEntity;
import com.fulln.service.Security.UserAuthorwareService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 自定义的securityservice
 * step 3
 */
@Service("userAuthorwareService")
public class UserAuthorwareServiceImpl implements UserAuthorwareService {

    private static Logger log = Logger.getLogger(UserAuthorwareServiceImpl.class);

    @Autowired
    private SysLoginDao sysLoginDao;

    @Override
    public userEmpEntity loadUserEntity(String userName) {
        userEmpEntity uentity = new userEmpEntity();
        uentity.setUsername(userName);
        userEmpEntity userEntity = sysLoginDao.selectOne(uentity);
        return userEntity;
    }
}