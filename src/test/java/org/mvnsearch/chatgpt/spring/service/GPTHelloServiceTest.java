package org.mvnsearch.chatgpt.spring.service;

import org.junit.jupiter.api.Test;
import org.mvnsearch.chatgpt.demo.ProjectBootBaseTest;
import org.mvnsearch.chatgpt.demo.service.GPTHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.test.StepVerifier;

import java.util.Locale;

class GPTHelloServiceTest extends ProjectBootBaseTest {

	@Autowired
	private GPTHelloService helloService;

	@Test
	void testTranslateIntoChinese() {
		StepVerifier.create(helloService.translateIntoChinese("Hello").map(result -> result.length() > 0))
			.expectNext(true)
			.verifyComplete();
	}

	@Test
	void testTranslate() {
		StepVerifier.create(helloService.translate("Chinese", "English", "你好！"))
			.expectNextMatches(result -> result.toLowerCase(Locale.ENGLISH).contains("hello"))
			.verifyComplete();

	}

	@Test
	void testTranslateFromTemplate() {
		StepVerifier.create(helloService.translateFromTemplate("Chinese", "English", "你好！"))
			.expectNextMatches(result -> result.toLowerCase(Locale.ENGLISH).contains("hello"))
			.verifyComplete();
	}

}
