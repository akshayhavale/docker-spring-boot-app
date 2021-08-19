package com.docker.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greet")
public class DockerApi {

	@GetMapping("/{name}")
	public String getGreetings(@PathVariable(value = "name") String name) {
		return new StringBuilder().append("Welcome to docker spring boot app Mr.").append(name).toString();
	}

}
