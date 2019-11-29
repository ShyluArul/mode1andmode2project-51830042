package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.entities.Account;
import com.bankapp.model.entities.Address;
import com.bankapp.model.entities.Customer;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.forms.AccountBlockBean;
import com.bankapp.web.forms.AccountRequest;
import com.bankapp.web.forms.CustomerRequest;

@Controller
@RequestMapping("/mgr")
public class AccountMgtController {
	
	@Autowired
	private AccountService accountService;
	
	
	
	
	
	
	@RequestMapping("/allaccounts")
	public ModelAndView getAllAccounts(ModelAndView mv){
		mv.setViewName("allaccounts");
		mv.addObject("accounts", accountService.getAllAccounts());
		mv.addObject("customers",accountService.getAllCustomers());
		
		return mv;
	}
	
	@RequestMapping(value="addaccount")
	public String addAccountGet(ModelMap map){
		map.addAttribute("account", new AccountRequest());
		return "addaccount";
		
	}
	@RequestMapping(value = "addaccount", method = RequestMethod.POST)
	public String addAccountPost( AccountRequest request,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addaccount";
		} else {
			Address address = new Address(request.getAddress(),request.getCity(),request.getPostalCode(),request.getStateName(),request.getCountry());
				Customer customer = new Customer(request.getName(),request.getEmail(),request.getPassword(),request.getPhone(),address);
				Account account = new Account(request.getAccountNumber(),request.getBalance(),request.isBlock(),customer,request.getAccountType());
				customer.setAccount(account);
				customer.setAddress(address);
				accountService.addAccount(account);
				accountService.addCustomer(customer);
				
		
				
			
				
				
				
			}
				
			return "redirect:allaccounts";
		}
	@PostMapping(value = "updatecustomer")
	public String updateAccountPost(Customer customer,CustomerRequest request,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "addaccount";
		} else {
		//	System.out.println(request.getAccountNumber());
			customer = accountService.findAccountByAccountNumber(request.getAccountNumber()).getCustomer();
			//System.out.println(account);
			System.out.println(customer.getEmail());
			customer.setEmail(request.getEmail());
			customer.setPhone(request.getPhone());
				accountService.updateCustomer(customer);
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
		Long accountNumber = Long.parseLong(req.getParameter("accountNumber"));
		Account accountToBeUpdate = accountService.findAccountByAccountNumber(accountNumber);
		System.out.println(accountToBeUpdate);
		map.addAttribute("customer", new CustomerRequest());
		return "updateCustomer";
	}
@RequestMapping(value="blocked")
public ModelAndView blockedPage(ModelAndView mv){
	mv.setViewName("blocked");
	return mv;

}
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String deleteAccount(HttpServletRequest req) {
		long accountId = Long.parseLong(req.getParameter("accountNumber"));
		accountService.deleteAccount(accountId);
		return "redirect:allaccounts";
	}
	
	@PostMapping(value = "blockaccount")
	public String blockAccountPost(Account account,
			AccountBlockBean blockBean) {
		//	System.out.println(request.getAccountNumber());
			account = accountService.findAccountByAccountNumber(blockBean.getAccountNumber());
			System.out.println(account);
			account.setBlock(true);
				accountService.blockAccount(account);
			return "redirect:blocked";	
	}
	@RequestMapping(value = "block", method = RequestMethod.GET)
	public String blockAccountGet( ModelMap map) {
	//	Long accountNumber = Long.parseLong(req.getParameter("accountNumber"));
		
		//System.out.println(accountToBeUpdate);
		map.addAttribute("account", new AccountBlockBean());
		return "blockAccount";
	}


}
