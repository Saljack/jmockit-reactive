package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.data.repository.DemoRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TestService {

  private final DemoRepository demoRepository;

  public String callMonoMethods() {
    Mono<String> one = demoRepository.testMethodOne();
    Mono<String> two = demoRepository.testMethodTwo();
    return Mono.zip(one, two)
      .map(tuple -> tuple.getT1() + tuple.getT2())
      .block();
  }

  public String callMonoMethodsNoGenerics() {
    Mono<String> one = demoRepository.testMethodOneNoGenerics();
    Mono<String> two = demoRepository.testMethodTwoNoGenerics();
    return Mono.zip(one, two)
      .map(tuple -> tuple.getT1() + tuple.getT2())
      .block();
  }

  public String callSimpleMethods() {
    return demoRepository.simpleOne() + demoRepository.simpleTwo();
  }

}
