package com.graphql.graphqlapi.modules;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class MongoDbModule{

    @Value("${mongodb.hostname}")
    private String hostname;
    
    @Value("${mongodb.port}")
    private int port;
    
    @Value("${mongodb.database}")
    private String databaseName;

        
    @Bean
    public MongoClient mongoClient() {
        String connectionString = "mongodb://" + hostname + ":" + port;
        return MongoClients.create(new ConnectionString(connectionString));
    }

    @Bean
    public MongoDatabase mongoDatabase(MongoClient mongoClient) {
        return mongoClient.getDatabase(databaseName);
    }

    @Bean
    public MongoCollection<Document> postCollection(MongoDatabase mongoDatabase) {
        return mongoDatabase.getCollection("post");
    }
}