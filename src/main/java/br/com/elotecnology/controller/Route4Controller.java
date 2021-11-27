package br.com.elotecnology.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/route4")
public class Route4Controller {
	
	@GetMapping
	public ResponseEntity<Object> get () {
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}

}
