package com.example.demo;

import org.springframework.http.server.RequestPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public String hello()
	{
		return String.format("<h1 >Spring running...</h1>");
	} 
	 
	@RequestMapping(value="/proper", method=RequestMethod.GET)
	public String sayHelloAgain()
	{
		return String.format("Giddy up!");
	}
	
	@RequestMapping(value="userform",method=RequestMethod.GET)
	public String userForm()
	{
		return String.format(
				 "<form action='user_entry' method='post'> "
				 + "Name: <input name='name'><br>" 
				 + "Age: <input name='age' type='text'></br>"
				 + "<input type='submit' value='Submit'>"
				 + "</form>");
	}
	
	
	@RequestMapping(value="user_entry", method =RequestMethod.POST)
	public String test(@RequestParam String name, @RequestParam String age)
	{
		
		
		return String.format("Hello %s, you are %s years old ", name, age);
	}
	
	@RequestMapping(value="orders/{id}", method = RequestMethod.GET)
	public long getOrder(@PathVariable long id)
	{
		
		return id;
	}
	
	
	@RequestMapping(value="/sysinfo", method = RequestMethod.GET)
	public String getInfo()
	{
		
		return String.format("<strong>OS Name:</strong> %s<br>"
				+ "<strong>OS version is:</strong> %s<br>"
				+ "<strong>OS Architecture:</strong> %s<br>"
				+ "<strong>User name:</strong> %s<br/>"
				+ "<strong>User home:</strong> %s<br/>"
					, System.getProperty("os.name"),System.getProperty("os.version"),
					System.getProperty("os.arch"),
					System.getProperty("user.name"),
					System.getProperty("user.home")
					
				);
	}

}
