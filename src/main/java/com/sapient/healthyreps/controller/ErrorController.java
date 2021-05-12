package com.sapient.healthyreps.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {
    @GetMapping("/*")
	public String handleError() {
		return "Error !!!";
	}
}