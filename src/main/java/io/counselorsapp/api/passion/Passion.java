package io.counselorsapp.api.passion;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Passion {
	@RequestMapping("/passion")
	public List<PassionSetters> getAllPassion() {
		return Arrays.asList(new PassionSetters("1","Biking","Bkers"),new PassionSetters("1","Cycleing","Cycleers"));
	}
}
