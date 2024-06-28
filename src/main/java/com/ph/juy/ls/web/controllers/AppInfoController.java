package com.ph.juy.ls.web.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class AppInfoController {

	@GetMapping("/")
	public String index() {
		return UUID.randomUUID().toString();
	}

}