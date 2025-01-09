package com.simplecrud.backend.application.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.index.Index;
import org.springframework.data.mongodb.core.index.IndexOperations;
import org.springframework.data.domain.Sort;

import com.simplecrud.backend.domain.model.UserModel;

@Configuration
public class MongoConfig {

    private final MongoTemplate mongoTemplate;

    public MongoConfig(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
        createIndexes();
    }

    private void createIndexes() {
        IndexOperations userIndexOperations = mongoTemplate.indexOps(UserModel.class);
        userIndexOperations.ensureIndex(new Index().on("username", Sort.Direction.ASC).unique());
    }
}
