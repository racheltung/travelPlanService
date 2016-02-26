package com.rachel.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rachel.vo.Greeting;

@Controller
public class GreetingAction {

	private static final String template = "Good, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	@ResponseBody
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

}
