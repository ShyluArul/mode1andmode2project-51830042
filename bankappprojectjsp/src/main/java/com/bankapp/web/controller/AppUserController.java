package com.bankapp.web.controller;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.exceptionhandler.UserNotFoundEx;
import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.User;
import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.model.service.UserService;
import com.bankapp.web.forms.AccountBlockBean;

@Controller
@RequestMapping("/admin")
public class AppUserController {

	@Autowired
	private UserService userService;
	@Autowired
	private TransactionLogService transactionLogService;
	@Autowired
	private AccountService accountService;
	
	
	@GetMapping(path="transaction")
	public ModelAndView transactions(ModelAndView mv){
		mv.setViewName("transaction");
		//System.out.println(transactionLogService.getAllTransactionLog());
		mv.addObject("transactions",transactionLogService.findAllTransactionLog());
		return mv;
	}
	
	@RequestMapping("/allusers")
	public ModelAndView getAllAppUsers(ModelAndView mv){
		mv.setViewName("all_appusers");
		mv.addObject("users", userService.getAllUsers());
		return mv;
	}
	@RequestMapping(value="adduser")
	public String addUserGet(ModelMap map){
		map.addAttribute("user", new User());
		return "adduser";
		
	}
	@RequestMapping(value = "adduser", method = RequestMethod.POST)
	public String addUserUpdatePost(User user,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "adduser";
		} else {
			System.out.println(user.getId());

			if (user.getId()== null)
				userService.addUser(user);
			else
				userService.updateUser(user.getId(),user);
			return "redirect:success";
		}
	}
	@RequestMapping(value="success")
	public ModelAndView successPage(ModelAndView mv){
		mv.setViewName("success");
		return mv;
	
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateUserGet(HttpServletRequest req, ModelMap map) {
		long userId = Long.parseLong(req.getParameter("id"));
		User userToBeUpdate = userService.findUserById(userId).orElseThrow(UserNotFoundEx::new);
		System.out.println(userToBeUpdate);
		map.addAttribute("user", userToBeUpdate);
		return "adduser";
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteUser(HttpServletRequest req) {
		long userId = Long.parseLong(req.getParameter("id"));
		userService.deleteUser(userId);
		return "redirect:allusers";
	}
	
}






