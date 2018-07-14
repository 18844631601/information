package com.smg.ssm.mapper;

import java.util.List;

import com.smg.ssm.po.Paper;
import com.smg.ssm.po.PaperCustom;
import com.smg.ssm.po.PaperVo;

/**
 * <p>Title: PaperMapperCustom</p>
 * <p>Description: 论文映射接口扩展类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月20日 下午9:46:26
 * @version 1.0
 */
public interface PaperMapperCustom {
	
	/**
	 * <p>Title: selectPaperList</p>
	 * <p>Description: 查询论文集合</p>
	 * @param paperVo
	 * @return
	 */
	public List<PaperCustom> selectPaperList(PaperVo paperVo);

	/**
	 * <p>Title: selectPaperNama</p>
	 * <p>Description: 查询论文集合对应用户名</p>
	 * @param paperCustom
	 * @return
	 */
	public PaperCustom selectPaperName(PaperVo paperVo);

	/**
	 * <p>Title: selectMyPaper</p>
	 * <p>Description: 查询自己论文</p>
	 * @param paperUtterer
	 * @return
	 */
	public List<PaperCustom> selectMyPaper(Integer paperUtterer);

	/**
	 * <p>Title: selectPaperState</p>
	 * <p>Description: 查询论文状态</p>
	 * @param paperContent
	 * @return
	 */
	public Integer selectPaperState(String paperContent);
	
	/**
	 * <p>Title: selectPaperContent</p>
	 * <p>Description: 根据论文编号查论文名</p>
	 * @param paperId
	 * @return
	 */
	public String selectPaperContent(String paperId);

	/**
	 * <p>Title: updatePaperReason</p>
	 * <p>Description: 更新论文原因</p>
	 * @param paper
	 */
	public Integer updatePaperReason(Paper paper);

	/**
	 * <p>Title: updatePaperState</p>
	 * <p>Description: 更新论文你状态为通过</p>
	 * @param state
	 * @return
	 */
	public Integer updatePaperState(Paper paper);
}
