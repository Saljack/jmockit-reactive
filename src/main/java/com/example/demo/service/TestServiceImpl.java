package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.data.repository.DemoRepository;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class TestServiceImpl implements TestService {

  private final DemoRepository demoRepository;

  @Override
  public String callMonoMethods() {
    return Mono.zip(demoRepository.testMethodOne(), demoRepository.testMethodTwo())
      .map(tuple -> tuple.getT1() + tuple.getT2())
      .block();
  }

  @Override
  public String callSimpleMethods() {
    return demoRepository.simpleOne() + demoRepository.simpleTwo();
  }
}
