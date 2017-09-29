package com.frontend.web.rest.demo;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.frontend.web.rest.demo.vo.Greeting;

@RestController
public class DemoRestController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@CrossOrigin
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		System.out.println("_____________>in greeting !");
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
