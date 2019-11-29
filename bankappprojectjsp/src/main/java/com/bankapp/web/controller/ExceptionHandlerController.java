package com.bankapp.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.bankapp.exceptionhandler.AccountNotFoundEx;
import com.bankapp.exceptionhandler.NotSufficientFundEx;

@ControllerAdvice
public class ExceptionHandlerController {
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handle404Ex(HttpServletRequest req, Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("404");
		mv.addObject("url", req.getRequestURL());
		mv.addObject("ex", ex);
		return mv;
	}

	/*
	 * @ExceptionHandler(NoHandlerFoundException.class) public ModelAndView
	 * handle404(){ ModelAndView mv=new ModelAndView(); mv.setViewName("404");
	 * mv.addObject("error", "Resource you are looking for is not found!");
	 * return mv; }
	 */
	@ExceptionHandler(AccountNotFoundEx.class)
	public ModelAndView handleAccountNotFundEx(HttpServletRequest req,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("errors_page");
		mv.addObject("url", req.getRequestURL());
		mv.addObject("ex", ex);
		return mv;
	}

	@ExceptionHandler(NotSufficientFundEx.class)
	public ModelAndView handleNotSufficientFundEx(HttpServletRequest req,
			Exception ex) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("errors_page");
		mv.addObject("url", req.getRequestURL());
		mv.addObject("ex", ex);
		return mv;
	}
}
