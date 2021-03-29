package com.example.demo.data.repository;

import reactor.core.publisher.Mono;

public interface DemoRepository  {

  Mono<String> testMethodOne();

  Mono<String> testMethodTwo();

  Mono testMethodOneNoGenerics();

  Mono testMethodTwoNoGenerics();

  String simpleOne();

  String simpleTwo();
}
