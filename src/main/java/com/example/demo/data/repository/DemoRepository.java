package com.example.demo.data.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.example.demo.data.entity.DemoEntity;

public interface DemoRepository extends ReactiveMongoRepository<DemoEntity, String>, CustomDemoRepository {
}
