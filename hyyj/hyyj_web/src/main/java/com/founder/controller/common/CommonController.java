package com.founder.controller.common;

import com.founder.utils.SystemConfig;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/common")
public class CommonController extends BaseController{
	
	@RequestMapping("/pageSize")
	@ResponseBody
	public int getPageSize(){
		int pageSize=0;
		try{			
			pageSize=SystemConfig.page;
		}catch(Exception e){
			throw new RuntimeException(e);
		}
		return pageSize;
	}
}
