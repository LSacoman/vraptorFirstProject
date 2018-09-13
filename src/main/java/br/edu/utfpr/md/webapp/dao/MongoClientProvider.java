package br.edu.utfpr.md.webapp.dao;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;

@Singleton
public class MongoClientProvider implements Serializable {

    private static final String DATABASE = "TESTE";
    private static MongoClient mongoClient;

    public MongoClientProvider() {
    }

    @PostConstruct
    public void init() {
        if(mongoClient == null){
            mongoClient = new MongoClient("localhost:27017");
        }
    }

    @Produces
    public MongoClient getMongoClient() {
        return mongoClient;
    }
    
    @Produces
    public MongoDatabase getDatabase(){
        return mongoClient.getDatabase(DATABASE);
    }
    
    @PreDestroy
    public void closeConnection(){
        if(mongoClient != null){
            mongoClient.close();
            mongoClient = null;
        }
    }
}
