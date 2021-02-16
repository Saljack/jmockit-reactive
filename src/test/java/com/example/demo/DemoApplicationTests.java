package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.data.repository.DemoRepository;
import com.example.demo.service.TestService;

import mockit.Capturing;
import mockit.Expectations;
import reactor.core.publisher.Mono;

@SpringBootTest
class DemoApplicationTests {

  @Autowired
  private TestService testService;

  @Test
  void testMono(@Capturing DemoRepository demoRepository) {
    new Expectations() {{
      demoRepository.testMethodOne();
      result = Mono.just("monoone");

      demoRepository.testMethodTwo();
      result = Mono.just("monotwo");
    }};

    String result = testService.callMonoMethods();

    assertThat(result, is("monoonemonotwo"));
  }

  @Test
  void testSimple(@Capturing DemoRepository demoRepository) {
    new Expectations() {{
      demoRepository.simpleOne();
      result = "simpleone";

      demoRepository.simpleTwo();
      result = "simpletwo";
    }};

    String result = testService.callSimpleMethods();

    assertThat(result, is("simpleonesimpletwo"));
  }

}
