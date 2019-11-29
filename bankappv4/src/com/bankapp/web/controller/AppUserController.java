package com.bankapp.web.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.AppUser;
import com.bankapp.model.service.UserService;

@Controller
@RequestMapping("/admin")
public class AppUserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/allusers")
	public ModelAndView getAllAppUsers(ModelAndView mv){
		mv.setViewName("all_appusers");
		mv.addObject("users", userService.getAllUsers());
		return mv;
	}
	@RequestMapping(value="adduser")
	public String addUserGet(ModelMap map){
		map.addAttribute("user", new AppUser());
		return "adduser";
		
	}
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String addUserUpdatePost(AppUser user,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "adduser";
		} else {

			if (user.getId()== 0)
				userService.addUser(user);
			else
				userService.updateUser(user);
			return "redirect:allusers";
		}
	}
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateUserGet(HttpServletRequest req, ModelMap map) {
		int userId = Integer.parseInt(req.getParameter("id"));
		AppUser userToBeUpdate = userService.getUserById(userId);
		System.out.println(userToBeUpdate);
		map.addAttribute("user", userToBeUpdate);
		return "adduser";
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest req) {
		int user_Id = Integer.parseInt(req.getParameter("id"));
		userService.deleteUser(user_Id);
		return "redirect:allusers";
	}

}






