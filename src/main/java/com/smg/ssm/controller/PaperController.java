package com.smg.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.ResponseWrapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.smg.ssm.po.Paper;
import com.smg.ssm.service.PaperService;

/**
 * <p>Title: PaperController</p>
 * <p>Description: 论文控制类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月17日 下午9:39:05
 * @version 1.0
 */
@Controller
@RequestMapping("/paper")
public class PaperController {
	
	@Autowired
	private PaperService paperService;
	
	/**
	 * <p>Title: selectPaperContent</p>
	 * <p>Description: 查询论文内容</p>
	 * @param response
	 * @param fileName
	 * @return
	 * @throws IOException
	 */
	@RequestMapping(value="/selectPaperContent/[{fileName}]",method=RequestMethod.GET)
    @ResponseBody
    public void selectPaperContent(HttpServletResponse response, @PathVariable("fileName") String fileName) throws IOException {
		paperService.selectPaperContent(response, fileName);
    }
	
	/**
	 * <p>Title: updatePaper</p>
	 * <p>Description: 修改论文</p>
	 * @param paper
	 * @param paperFile
	 * @return
	 */
	@RequestMapping(value="/updatePaper",method=RequestMethod.POST)
	@ResponseJSONP
	public String updatePaper(Paper paper, MultipartFile paperFile) {
		Integer result = paperService.updatePaper(paper, paperFile);
		Map<String,Integer> resultMap = new HashMap<String,Integer>();
		resultMap.put("result", result);
		return JSON.toJSONString(resultMap);
	}
	
	/**
	 * <p>Title: deletePaper</p>
	 * <p>Description: 删除个人论文</p>
	 * @param paperId
	 * @return
	 */
	@RequestMapping(value="/deletePaper",method=RequestMethod.DELETE)
	@ResponseJSONP
	public String deletePaper(String paperId) {
		Integer result = paperService.deletePaper(paperId);
		Map<String,Integer> resultMap = new HashMap<String,Integer>();
		resultMap.put("result", result);
		return JSON.toJSONString(resultMap);
	}

	/**
	 * <p>Title: addPaper</p>
	 * <p>Description: 添加论文</p>
	 * @param paper
	 * @return
	 */
	@RequestMapping(value="/addPaper",method=RequestMethod.POST)
	@ResponseJSONP
	public String addPaper(Paper paper, MultipartFile paperFile) {
		Integer result = paperService.addPaper(paper, paperFile);
		Map<String,Integer> resultMap = new HashMap<String,Integer>();
		resultMap.put("result", result);
		return JSON.toJSONString(resultMap);
	}

	/**
	 * <p>Title: updatePaperReason</p>
	 * <p>Description: 更新论文原因</p>
	 * @param paperContent
	 * @param paperReason
	 * @return
	 */
	@RequestMapping(value="/updatePaperReason",method=RequestMethod.PUT)
	@ResponseBody
	public Integer updatePaperReason(String paperId, String paperReason) {
		return paperService.updatePaperReason(paperId, paperReason);
	}
	
	/**
	 * <p>Title: updatePaperState</p>
	 * <p>Description: 更新论文你状态为通过</p>
	 * @param state
	 * @return
	 */
	@RequestMapping(value="/updatePaperState",method=RequestMethod.PUT)
	@ResponseJSONP
	public Integer updatePaperState(String paperId, Integer state) {
		return paperService.updatePaperState(paperId, state);
	}
	/**
	 * <p>Title: selectPaper</p>
	 * <p>Description: 查询单个论文</p>
	 * @param paperId
	 * @return
	 */
	@RequestMapping(value="/selectPaper/{paperId}",method=RequestMethod.GET)
	@ResponseBody
	public Paper selectPaper(@PathVariable("paperId") String paperId) {
		Paper paper = paperService.selectPaper(paperId);
		return paper;
	}
		
	/**
	 * <p>Title: selectMyPaper</p>
	 * <p>Description: 查询个人论文</p>
	 * @param paperUtterer
	 * @return
	 */
	@RequestMapping(value="/selectMyPaper/{paperUtterer}",method=RequestMethod.GET)
	@ResponseJSONP
	public String selectMyPaper(@PathVariable("paperUtterer") Integer paperUtterer) {
		return JSON.toJSONString(paperService.selectMyPaper(paperUtterer));
	}

	/**
	 * <p>Title: selectPaperList</p>
	 * <p>Description: 查询论文集合</p>
	 * @param index
	 * @param selectString
	 * @return
	 */
	@RequestMapping(value="/selectPaperList/{index}/{selectString}",method=RequestMethod.GET)
	@ResponseJSONP
	public String selectPaperList(@PathVariable("index") Integer index, @PathVariable("selectString") String selectString) throws Exception{
		try {
			selectString = URLDecoder.decode(selectString,"utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return JSON.toJSONString(paperService.selectPaperList(index, selectString));
	}

	/**
	 * <p>Title: selectPaperState</p>
	 * <p>Description: 根据论文名查状态</p>
	 * @param paperContent
	 * @return
	 */
	@RequestMapping(value="/selectPaperState/[{paperContent}]",method=RequestMethod.GET)
	@ResponseJSONP
	public String selectPaperState(@PathVariable("paperContent") String paperContent) {
		Integer paperState = paperService.selectPaperState(paperContent);
		Map<String, Integer> result = new HashMap<String, Integer>();
		result.put("paperState", paperState);
		return JSON.toJSONString(result);
	}

}
