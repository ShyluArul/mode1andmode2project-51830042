package com.bankapp.web.controller;

import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bankapp.model.dao.Account;
import com.bankapp.model.dao.AccountType;
import com.bankapp.model.service.AccountService;
import com.bankapp.web.forms.DepositWithdrawBean;
import com.bankapp.web.forms.TransferBean;

@Controller
@RequestMapping(path="clerk")
public class TransactionController {

	@Autowired
	private AccountService accountService;
	
	//@PostConstruct
	public void addDefaultAccounts(){
		System.out.println("________________________________________________");
		accountService.saveAccount(new Account(1000, "A", "SAVING", false, false));
		accountService.saveAccount(new Account(1000, "B", "SAVING", false, false));
		System.out.println("accounts are added....s");
	}
	 
	@GetMapping(path="allaccounts")
	public ModelAndView getAllAccounts(ModelAndView mv){
		mv.setViewName("allaccounts");
		mv.addObject("accounts", accountService.getAllAccounts());
		return mv;
	}
	
	@GetMapping(path="transfer")
	public String transferFundGet(ModelMap map){
		map.addAttribute("transferBean", new TransferBean());
		return "transfer";
	}
	
	@PostMapping(path="transfer")
	public String transferFundPost(@Valid @ModelAttribute(name="transferBean")
	TransferBean transferBean, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "transfer";
		}
		accountService.transferFund(transferBean.getFromAccount(),
				transferBean.getToAccount(), transferBean.getAmount());
		
		return "redirect:allaccounts";
	}

	
	@GetMapping(path="deposit")
	public String depositGet(ModelMap map){
		map.addAttribute("depositWithdrawBean", new DepositWithdrawBean());
		return "deposit";
	}
	
	@PostMapping(path="deposit")
	public String depositPost(@Valid @ModelAttribute(name="depositWithdrawBean")
	DepositWithdrawBean depositWithdrawBean, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "deposit";
		}
		accountService.deposit(depositWithdrawBean.getAccountNo(),
				depositWithdrawBean.getAmount());
		return "redirect:allaccounts";
	}
	

	@GetMapping(path="withdraw")
	public String withdrawGet(ModelMap map){
		map.addAttribute("depositWithdrawBean", new DepositWithdrawBean());
		return "withdraw";
	}
	
	@PostMapping(path="withdraw")
	public String withdrawPost(@Valid @ModelAttribute(name="depositWithdrawBean")
	DepositWithdrawBean depositWithdrawBean, BindingResult bindingResult){
		if(bindingResult.hasErrors()){
			return "withdraw";
		}
		accountService.withdraw(depositWithdrawBean.getAccountNo(),
				depositWithdrawBean.getAmount());
		return "redirect:allaccounts";
	}

	
}





