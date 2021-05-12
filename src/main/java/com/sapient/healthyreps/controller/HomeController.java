package com.sapient.healthyreps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
	public String health() {
		return "Welcome to healthyreps blog and QnA Homepage!";
	}
}
