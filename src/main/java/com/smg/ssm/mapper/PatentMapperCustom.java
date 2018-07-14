package com.smg.ssm.mapper;

import java.util.List;

import com.smg.ssm.po.Patent;
import com.smg.ssm.po.PatentCustom;
import com.smg.ssm.po.PatentVo;

/**
 * <p>Title: PatentMapperCustom</p>
 * <p>Description: 专利映射扩展类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年7月5日 下午10:28:26
 * @version 1.0
 */
public interface PatentMapperCustom {

	/**
	 * <p>Title: selectPatentList</p>
	 * <p>Description: 查询所有专利</p>
	 * @param patentVo
	 * @return List<PatentCustom>
	 */
	List<PatentCustom> selectPatentList(PatentVo patentVo);

	/**
	 * <p>Title: selectMyPatent</p>
	 * <p>Description: 查询自己的专利</p>
	 * @param patentId
	 * @return List<PatentCustom>
	 */
	List<PatentCustom> selectMyPatent(Integer patentPatentee);
		
}
