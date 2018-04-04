package com.fulln.dao.Mongo;

import com.fulln.Mongo.dao.MongoBaseDao;
import com.fulln.entity.Mongo.UserEntity;

public interface UserDao extends MongoBaseDao<UserEntity> {

     void saveUser(UserEntity user);

     UserEntity findUserByUserName(String userName);

     void updateUser(UserEntity user);

    public void deleteUserById(int id);

}
