package com.example.JavaPractice;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class JavaPracticeApplicationTests {

	@Value("${test}")
	private static String str;

	@Test
	void contextLoads() {
		System.out.println(str);
	}

}
