package com.fulln.Mongo.dao.Impl;

import com.fulln.Mongo.dao.MongoBaseDao;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Component
public  abstract class MongoBaseDaoImpl<T>  implements MongoBaseDao<T> {

    private static Logger log = LoggerFactory.getLogger(MongoBaseDaoImpl.class);

    private Class<T> c;

    @Resource
    private MongoTemplate mongoTemplate;

    /*新增*/
    public void insertOne(T t) throws DataAccessException {
            mongoTemplate.insert(t);
    }

    /*批量新增*/
    public void insertList(List<T> list) throws DataAccessException {
            mongoTemplate.insertAll(list);
    }

    /*删除 根据主键id删除
    * 主键id, 如果主键的值为null,删除会失败
     * */
    public void deleteById(String id)throws DataAccessException {
            DBObject objVO = new BasicDBObject();
            objVO.put("_id", id);
            mongoTemplate.remove(objVO);
    }

    /*删除  根据条件删除*/
    public void delete(T t){

//        Criteria criteria = Criteria.where("age").gt(criteriaUser.getAge());
//        Query query = new Query(criteria);
//        mongoTemplate.remove(query, User.class);
    }
    /*删表*/
    public void deleteAll()  throws DataAccessException {
        mongoTemplate.dropCollection(c);
    }

    /*
     * 按主键修改,
     * 如果文档中没有相关key 会新增 使用$set修改器
     * */

    /**
     * 查询全部
     * @return
     */
    public List<T> findAll()  throws Exception{
        return mongoTemplate.findAll(c);
    }
    /**
     * 根据主键查询
     * @param id
     * @return
     */
    public T findById(String id) {
        // TODO Auto-generated method stub
        return mongoTemplate.findById(id,c);
    }

}
