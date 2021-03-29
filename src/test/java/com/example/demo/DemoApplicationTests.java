package com.example.demo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.data.repository.DemoRepository;
import com.example.demo.data.repository.DemoRepositoryImpl;
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
      times = 1;

      demoRepository.testMethodTwo();
      result = Mono.just("monotwo");
      times = 1;
    }};

    String result = testService.callMonoMethods();

    assertThat(result, is("monoonemonotwo"));
  }

  @Test
  void testMonoDemoRepositoryImpl(@Capturing DemoRepositoryImpl demoRepository) {
    new Expectations() {{
      demoRepository.testMethodOne();
      result = Mono.just("monoone");
      times = 1;

      demoRepository.testMethodTwo();
      result = Mono.just("monotwo");
      times = 1;
    }};

    String result = testService.callMonoMethods();

    assertThat(result, is("monoonemonotwo"));
  }

  @Test
  void testSimple(@Capturing DemoRepository demoRepository) {
    new Expectations() {{
      demoRepository.simpleOne();
      result = "simpleone";
      times = 1;

      demoRepository.simpleTwo();
      result = "simpletwo";
      times = 1;
    }};

    String result = testService.callSimpleMethods();

    assertThat(result, is("simpleonesimpletwo"));
  }

}
