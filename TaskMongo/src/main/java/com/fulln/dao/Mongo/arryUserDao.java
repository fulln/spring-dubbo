package com.fulln.dao.Mongo;

import com.fulln.Mongo.dao.MongoBaseDao;
import com.fulln.entity.Mongo.arryUser;

public interface arryUserDao extends MongoBaseDao<arryUser>{

    arryUser findOne(arryUser criteriaUser) throws InstantiationException,
           IllegalAccessException;

}
