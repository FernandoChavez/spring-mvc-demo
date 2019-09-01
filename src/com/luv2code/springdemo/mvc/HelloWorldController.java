package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
	//need a controller method to show the initial HTML form
	
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	
	
	//need a controller method to process the HTML form
	
	@RequestMapping
	public String processForm(){
		return "helloworld";
	}
	
	//new a controller method to read form data and
	// add data to the model
	
	@RequestMapping("/processFormVersionTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		
		//read the request parameter form HTML form
		String theName= request.getParameter("studentName");
		
		//Convert the data all caps
		theName = theName.toUpperCase();
		
		//Create the message
		String result = "Yo! " + theName;
		
		//Add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormVersionThree")
	public String processFormVersionThree(@RequestParam("studentName") String theName, Model model) {
		
		//Convert the data all caps
		theName = theName.toUpperCase();
		
		//Create the message
		String result = "Hey my friend from v3! " + theName;
		
		//Add message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
