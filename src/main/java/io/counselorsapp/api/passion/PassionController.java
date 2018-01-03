package io.counselorsapp.api.passion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import io.counselorsapp.api.passion.Passion;
import io.counselorsapp.api.passion.PassionDBFunction;
@RestController
@RequestMapping("passion")
public class PassionController {
	@Autowired
	private PassionInterService passionService;
	@GetMapping("passion")
	public ResponseEntity<List<Passion>> getAllPassion() {
		List<Passion> list = passionService.getAllPassion();
		return new ResponseEntity<List<Passion>>(list, HttpStatus.OK);
	}
	@GetMapping("passion/{id}")
	public ResponseEntity<Passion> getArticleById(@PathVariable("id") Integer id) {
		Passion article = passionService.getPassionById(id);
		return new ResponseEntity<Passion>(article, HttpStatus.OK);
	}
	
	@PostMapping("passion")
	public ResponseEntity<Void> addPassion(@RequestBody Passion passio, UriComponentsBuilder builder) {
        boolean flag = passionService.addPassion(passio);
        if (flag == false) {
	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/passion/{id}").buildAndExpand(passio.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	
}
