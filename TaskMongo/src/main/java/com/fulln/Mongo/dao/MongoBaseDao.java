package com.fulln.Mongo.dao;

import org.springframework.dao.DataAccessException;

import java.util.List;

public interface MongoBaseDao<T> {

     void insertOne(T t);

     void insertList(List<T> list) throws DataAccessException;

     void deleteById(String id) throws Exception;

     void deleteAll()  throws DataAccessException;

     List<T> findAll()  throws Exception;

    public T findById(String id);

}
