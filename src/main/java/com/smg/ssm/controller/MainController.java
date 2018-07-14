package com.smg.ssm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>Title: MainController</p>
 * <p>Description: 首页控制器</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年7月4日 下午8:17:57
 * @version 1.0
 */
@Controller
public class MainController {
	
	/**
	 * <p>Title: toMainPage</p>
	 * <p>Description: 跳转到首页</p>
	 * @return ModelAndView
	 */
	@RequestMapping(value="/toMainPage",method=RequestMethod.GET)
	public ModelAndView toMainPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userType", 0);
		modelAndView.setViewName("main");
		return modelAndView;
	}
	
	/**
	 * <p>Title: toPaperPage</p>
	 * <p>Description: 跳转到论文页</p>
	 * @return ModelAndView
	 */
	@RequestMapping(value="toPaperPage",method=RequestMethod.GET)
	public ModelAndView toPaperPage() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("", 0);
		modelAndView.setViewName("paper/paper");
		return modelAndView;
	}
	
	/**
	 * <p>Title: toPatentPage</p>
	 * <p>Description: 跳转到专利页</p>
	 * @return ModelAndView
	 */
	@RequestMapping(value="toPatentPage",method=RequestMethod.GET)
	public ModelAndView toPatentPage() {
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.addObject("", 0);
		modelAndView.setViewName("patent/patent");
		return modelAndView;
	}
	
}
