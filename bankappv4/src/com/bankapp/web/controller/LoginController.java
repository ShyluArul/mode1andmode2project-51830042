package com.bankapp.web.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class LoginController {

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied(Principal user) {

		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName()
					+ ", You can not access this page!");
		} else {
			model.addObject("msg", "You can not access this page!");
		}

		model.setViewName("403");
		return model;
	}

	@RequestMapping("/")
	public String home() {
		return "home";
	}

	/*@RequestMapping("/login")
	public String login() {
		return "login";
	}*/
	
	 /*@RequestMapping(value="/login", method = RequestMethod.GET)
	  public String login(ModelMap model, Principal principal ) {
	 
	      String name = principal.getName(); //get logged in username
	      model.addAttribute("username", name);
	      return "login";
	 
	  }*/
	 @RequestMapping(value="/dashboard", method = RequestMethod.GET)
	  public String printWelcome(ModelMap model, Principal principal ) {
	 
	      String name = principal.getName(); //get logged in username
	      model.addAttribute("username", name);
	      return "dashboard";
	 
	  }
	 /*@RequestMapping(value = "logout")
		public String logout(ModelMap map) {
			return "login";
		}
	 */
	 
	 @RequestMapping(value = "/loginPage", method = RequestMethod.GET)
		public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
		@RequestParam(value = "logout",	required = false) String logout) {
			
			ModelAndView model = new ModelAndView();
			if (error != null) {
				model.addObject("error", "Invalid Credentials provided.");
			}

			if (logout != null) {
				model.addObject("message", "Logged out successfully.");
			}

			model.setViewName("loginPage");
			return model;
		}
}
