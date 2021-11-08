package it.blog.webclientasync;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class WebClientAsyncApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebClientAsyncApplication.class, args);
	}

}
