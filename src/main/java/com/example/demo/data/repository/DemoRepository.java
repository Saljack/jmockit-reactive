package com.example.demo.data.repository;

import reactor.core.publisher.Mono;

public interface DemoRepository  {

  Mono testMethodOne();

  Mono testMethodTwo();

  String simpleOne();

  String simpleTwo();
}
