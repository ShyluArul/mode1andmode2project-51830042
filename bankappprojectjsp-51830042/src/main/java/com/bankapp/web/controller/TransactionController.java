package com.bankapp.web.controller;

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

import com.bankapp.model.service.AccountService;
import com.bankapp.model.service.TransactionLogService;
import com.bankapp.web.forms.DepositWithdrawBean;
import com.bankapp.web.forms.TransferBean;

@Controller
@RequestMapping(path="clerk")
public class TransactionController {

	@Autowired
	private AccountService accountService;
	
	@Autowired
	private TransactionLogService transactionLogService;
	
	
	
	 
	@GetMapping(path="allaccounts")
	public ModelAndView getAllAccounts(ModelAndView mv){
		mv.setViewName("allaccounts");
		mv.addObject("accounts", accountService.getAllAccounts());
		mv.addObject("customers",accountService.getAllCustomers());
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
		accountService.transfer(transferBean.getFromAccount(),
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





