package com.smg.ssm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.smg.ssm.po.Patent;
import com.smg.ssm.po.PatentCustom;
import com.smg.ssm.po.PatentVo;
import com.smg.ssm.service.PatentService;

/**
 * <p>Title: PatentController</p>
 * <p>Description: 专利控制类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年7月5日 下午9:36:18
 * @version 1.0
 */
@Controller
@RequestMapping("/patent")
public class PatentController {
	
	@Autowired
	private PatentService patentService;
	
	/**
	 * <p>Title: selectedPatentList</p>
	 * <p>Description: 查询所有专利</p>
	 * @param patentVo
	 * @return List<PatentCustom>
	 */
	@RequestMapping(value="/selectPatentList",method=RequestMethod.GET)
	@ResponseJSONP
	public String selectedPatentList(PatentVo patentVo) {
		return JSON.toJSONString(patentService.selectPatentList(patentVo));
	}
	
	/**
	 * <p>Title: selectPatent</p>
	 * <p>Description: 查询自己的专利</p>
	 * @param patentId
	 * @return List<PatentCustom>
	 */
	@RequestMapping(value="/selectMyPatent/{patentPatentee}",method=RequestMethod.GET)
	@ResponseJSONP
	public String selectMyPatent(@PathVariable("patentPatentee") Integer patentPatentee) {
		return JSON.toJSONString(patentService.selectMyPatent(patentPatentee));
	}
	
	/**
	 * <p>Title: addPatent</p>
	 * <p>Description: 添加专利</p>
	 * @param patent
	 * @return int
	 */
	@RequestMapping(value="/addPatent",method=RequestMethod.POST)
	@ResponseJSONP
	public int addPatent(Patent patent) {
		return patentService.addPatent(patent);
	}
	
	/**
	 * <p>Title: updatePatent</p>
	 * <p>Description: 更新专利</p>
	 * @param patent
	 * @return int
	 */
	@RequestMapping(value="/updatePatent",method=RequestMethod.PUT)
	@ResponseJSONP
	public int updatePatent(Patent patent) {
		return patentService.updatePatent(patent);
	}
	
	/**
	 * <p>Title: deletePatent</p>
	 * <p>Description: 根据专利id删除专利</p>
	 * @param patentId
	 * @return int
	 */
	@RequestMapping(value="/deletePatent",method=RequestMethod.DELETE)
	@ResponseJSONP
	public int deletePatent(String patentId) {
		return patentService.deletePatent(patentId);
	}
}
