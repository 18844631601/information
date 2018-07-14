package com.smg.ssm.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.smg.ssm.po.Paper;
import com.smg.ssm.po.PaperCustom;

/**
 * <p>Title: PaperService</p>
 * <p>Description: 论文服务接口类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月17日 下午9:45:15
 * @version 1.0
 */
public interface PaperService {

	/** 
	 * <p>Title: addPaper</p>
	 * <p>Description: 添加论文</p>
	 * @return
	 */
	Integer addPaper(Paper paper, MultipartFile paperFile);

	/**
	 * <p>Title: deletePaper</p>
	 * <p>Description: 删除论文</p>
	 * @return
	 */
	Integer deletePaper(String paperId);

	/**
	 * <p>Title: updatePaper</p>
	 * <p>Description: 修改论文</p>
	 * @return
	 */
	Integer updatePaper(Paper paper, MultipartFile paperFile);

	/**
	 * <p>Title: updatePaperReason</p>
	 * <p>Description: 根据论文名更新原因</p>
	 * @param paperContent
	 * @return
	 */
	Integer updatePaperReason(String paperId, String paperReason);
	
	/**
	 * <p>Title: updatePaperState</p>
	 * <p>Description: 更新论文你状态为通过</p>
	 * @param state
	 * @return
	 */
	Integer updatePaperState(String paperId, Integer state);
	
	/**
	 * <p>Title: selectPaper</p>
	 * <p>Description: 查询单个论文</p>
	 * @param paperId
	 * @return
	 */
	Paper selectPaper(String paperId);

	/**
	 * <p>Title: selectPaperList</p>
	 * <p>Description: 查询论文集合</p>
	 * @param index
	 * @param selectString
	 * @return
	 */
	List<PaperCustom> selectPaperList(Integer index, String selectString) throws Exception;

	/**
	 * <p>Title: selectMyPaper</p>
	 * <p>Description: 查询自己论文</p>
	 * @param paperUtterer
	 * @return
	 */
	List<PaperCustom> selectMyPaper(Integer paperUtterer);

	/**
	 * <p>Title: selectPaperContent</p>
	 * <p>Description: 根据文件名查询论文内容</p>
	 * @param response
	 * @param fileName
	 * @return
	 */
	void selectPaperContent(HttpServletResponse response, String fileName);

	/**
	 * <p>Title: selectPaperState</p>
	 * <p>Description: 根据论文名查状态</p>
	 * @param paperContent
	 * @return
	 */
	Integer selectPaperState(String paperContent);



}