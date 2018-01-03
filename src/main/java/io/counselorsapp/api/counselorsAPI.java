package io.counselorsapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@SpringBootApplication(exclude = [ContextStackAutoConfiguration])
public class counselorsAPI {

	public static void main(String[] args) {
		SpringApplication.run(counselorsAPI.class, args);
	}

}
