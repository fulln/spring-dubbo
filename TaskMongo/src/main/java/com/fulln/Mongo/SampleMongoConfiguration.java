package com.fulln.Mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoTypeMapper;

import javax.annotation.Resource;
//
//@Configuration
//class SampleMongoConfiguration extends AbstractMongoConfiguration {
//
//  @Override
//  protected String getDatabaseName() {
//    return "testdb";
//  }
//
//  @Resource
//  private MongoClient mongoClient;
//
//  @Override
//  public Mongo mongo() throws Exception {
//    return this.mongoClient;
//  }
//
//  @Bean
//  @Override
//  public MappingMongoConverter mappingMongoConverter() throws Exception {
//    MappingMongoConverter mmc = super.mappingMongoConverter();
//    mmc.setTypeMapper(customTypeMapper());
//    return mmc;
//  }
//
//  @Bean
//  public MongoTypeMapper customTypeMapper() {
//    return new CustomMongoTypeMapper();
//  }
//}