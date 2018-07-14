package com.smg.ssm.service;

import java.util.List;

import com.smg.ssm.po.Patent;
import com.smg.ssm.po.PatentCustom;
import com.smg.ssm.po.PatentVo;

/**
 * <p>Title: PatentService</p>
 * <p>Description: 专利服务接口类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年7月7日 上午9:10:30
 * @version 1.0
 */
public interface PatentService {

	/**
	 * <p>Title: selectPatentList</p>
	 * <p>Description: 查询所有专利</p>
	 * @return List<Patent>
	 */
	List<PatentCustom> selectPatentList(PatentVo patentVo);

	/**
	 * <p>Title: addPatent</p>
	 * <p>Description: 添加专利</p>
	 * @param patent
	 * @return int
	 */
	int addPatent(Patent patent);

	/**
	 * <p>Title: deletePatent</p>
	 * <p>Description: 根据专利id删除专利</p>
	 * @param patentId
	 * @return int
	 */
	int deletePatent(String patentId);

	/**
	 * <p>Title: updatePatent</p>
	 * <p>Description: 更新专利</p>
	 * @param patent
	 * @return int
	 */
	int updatePatent(Patent patent);

	/**
	 * <p>Title: selectMyPatent</p>
	 * <p>Description: 查询自己的专利</p>
	 * @param patentId
	 * @return List<PatentCustom>
	 */
	List<PatentCustom> selectMyPatent(Integer patentPatentee);

}