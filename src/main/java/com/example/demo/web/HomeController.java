package com.example.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.domain.User;

@Controller
public class HomeController {

		@RequestMapping("/")
		public String home(Model model)
		{
			model.addAttribute("formData",new User());
			return "index";
		}
		
		@RequestMapping(value ="/create", method=RequestMethod.POST)
		public String processData(User user, RedirectAttributes reAttr)
		{	
			reAttr.addFlashAttribute("user", user);
//			return "responsetest";
			return "redirect:/display";
		}
		
		@RequestMapping(value="/display", method = RequestMethod.GET)
		public String displayFormData(User user)
		{
			return "responsetest"; 
		}
}
