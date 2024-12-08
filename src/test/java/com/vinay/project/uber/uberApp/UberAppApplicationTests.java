package com.vinay.project.uber.uberApp;

import com.vinay.project.uber.uberApp.services.EmailSenderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UberAppApplicationTests {

	@Autowired
	private EmailSenderService emailSenderService;

	@Test
	void contextLoads() {
		emailSenderService.sendEmail(
				"peyapoc163@datingel.com",
				"This is the Testing Email.",
				"Body of my email."
		);
	}

	@Test
	void sendEmailMultiple() {
		String[] emails ={
				"peyapoc163@datingel.com",
				"homemypc007@gmail.com"
		};
		emailSenderService.sendEmail(
				emails,
				"Uber Mail testing",
				"Hello World"
		);
	}

}
