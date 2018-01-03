package io.counselorsapp.api.hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloApplication {
	@RequestMapping("/show")
	public String hello() {
		return "Hello";
	}
}
