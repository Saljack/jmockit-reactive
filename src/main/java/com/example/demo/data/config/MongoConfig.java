package com.example.demo.data.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

import com.example.demo.data.repository.DemoRepository;

@Configuration
@EnableReactiveMongoRepositories(basePackageClasses = DemoRepository.class)
@EnableMongoRepositories
public class MongoConfig {
}
