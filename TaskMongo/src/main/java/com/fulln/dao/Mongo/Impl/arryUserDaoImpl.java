package com.fulln.dao.Mongo.Impl;

import com.fulln.Mongo.MongoMapper;
import com.fulln.dao.Mongo.arryUserDao;
import com.fulln.entity.Mongo.arryUser;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class arryUserDaoImpl extends MongoMapper<arryUser> implements arryUserDao {


    @Resource
    private MongoTemplate mongoTemplate;

    /**按id查询  分页
     * @param criteriaUser
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    public arryUser findOne(arryUser criteriaUser) throws InstantiationException, IllegalAccessException {
        // TODO Auto-generated method stub
//        Query query=new Query(Criteria.where("userName").is(userName));

//        query.skip(criteriaUser.getPageNo());
//        query.limit(criteriaUser.getPageSize());
        return mongoTemplate.findById(criteriaUser.getId(), arryUser.class);
    }

    private Query getQuery(arryUser criteriaUser) {
        if (criteriaUser == null) {
            criteriaUser = new arryUser();
        }
        Query query = new Query();
        if (criteriaUser.getId() != null) {
            Criteria criteria = Criteria.where("id").is(criteriaUser.getId());
            query.addCriteria(criteria);
        }
        if (criteriaUser.getSex()> 0) {
            Criteria criteria = Criteria.where("sex").gt(criteriaUser.getSex());
            query.addCriteria(criteria);
        }
        if (criteriaUser.getUsername() != null) {
            Criteria criteria = Criteria.where("name").regex("^" + criteriaUser.getUsername());
            query.addCriteria(criteria);
        }
        return query;
    }

}
