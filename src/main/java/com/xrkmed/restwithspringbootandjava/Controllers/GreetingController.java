package com.xrkmed.restwithspringbootandjava.Controllers;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xrkmed.restwithspringbootandjava.Greeting;

@RestController
@RequestMapping("/v1")
public class GreetingController {

	  private static final String template = "Hello, %s!";
	  private static AtomicLong counter = new AtomicLong();
	  
	  @RequestMapping("/greeting")
	  public HashMap<Object, Object> greeting(@RequestParam(value="name", defaultValue = "World") String name) {
		  HashMap<Object, Object> _result = new HashMap();
		  Greeting greeting = new Greeting(counter.getAndIncrement(), String.format(template, name));
		  _result.put("id", greeting.getId());
		  _result.put("content", greeting.getContent());
		  _result.put("apiVersion", "v1");
		  return _result;
	  }
	
}
