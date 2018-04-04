package com.fulln.Mongo;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import java.net.UnknownHostException;

import static java.util.Collections.singletonList;

@Configuration
public class ApplicationContextEventTestsAppConfig extends AbstractMongoConfiguration {

    @Override
    public String getDatabaseName() {
        return "testdb";
    }


    @Bean
    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(singletonList(new ServerAddress("127.0.0.1", 27017)),
                singletonList(MongoCredential.createCredential("test", "testdb", "test".toCharArray())));
    }


}
