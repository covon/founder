package com.founder.controller.common;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/error")
public class ErrorController extends BaseController{
	@RequestMapping("/system")
	public ModelAndView errorSystem(){
		ModelAndView mv=new ModelAndView();
		
		return mv;
	}
}
