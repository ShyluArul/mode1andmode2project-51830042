package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountNotFoundException;
import com.bankapp.model.dao.AppUser;
import com.bankapp.model.service.AccountService;

@Controller
@RequestMapping("/mgr")
public class AccountMgtController {
	
	@Autowired
	private AccountService accountService;
	
	@RequestMapping("/allaccounts")
	public ModelAndView getAllAccounts(ModelAndView mv){
		mv.setViewName("allaccounts");
		mv.addObject("accounts", accountService.getAllAccounts());
		return mv;
	}
	@RequestMapping(value="addaccount")
	public String addAccountGet(ModelMap map){
		map.addAttribute("account", new Account());
		return "addaccount";
		
	}
	@RequestMapping(value = "addaccount", method = RequestMethod.POST)
	public String addAccountUpdatePost(Account account,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addaccount";
		} else {

			if (account.getId()==0)
				accountService.saveAccount(account);
			else
				accountService.updateAccount(account);
			return "redirect:allaccounts";
		}
	}
	
	/*@RequestMapping(value = "addaccount", method = RequestMethod.POST)
	public String addAccountPost(Account account,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addaccount";
		} else {

			
				accountService.addAccount(account);
			
			return "redirect:allaccounts";
		}
	}
	@RequestMapping(value = "updateaccount", method = RequestMethod.POST)
	public String updateAccountPost(Account account,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "updateaccount";
		} else {
				accountService.updateAccount(account);
			return "redirect:allaccounts";
		}
	}
*/	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String updateAccountGet(HttpServletRequest req, ModelMap map) {
		int accountId = Integer.parseInt(req.getParameter("id"));
		Account accountToBeUpdate = accountService.getAccount(accountId);
		System.out.println(accountToBeUpdate);
		map.addAttribute("account", accountToBeUpdate);
		return "addaccount";
	}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest req) {
		int account_Id = Integer.parseInt(req.getParameter("id"));
		accountService.deleteAccount(account_Id);
		return "redirect:allaccounts";
	}


}
