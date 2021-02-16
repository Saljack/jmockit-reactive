package com.example.demo.data.repository;

import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public class CustomDemoRepositoryImpl implements CustomDemoRepository {

  private static final String ONE = "one";
  private static final String TWO = "two";

  @Override
  public Mono<String> testMethodOne() {
    return Mono.just(ONE);
  }

  @Override
  public Mono<String> testMethodTwo() {
    return Mono.just(TWO);
  }

  @Override
  public String simpleOne() {
    return ONE;
  }

  @Override
  public String simpleTwo() {
    return TWO;
  }
}
