package com.smg.ssm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.annotation.JSONField;
import com.smg.ssm.mapper.PatentMapper;
import com.smg.ssm.mapper.PatentMapperCustom;
import com.smg.ssm.po.Patent;
import com.smg.ssm.po.PatentCustom;
import com.smg.ssm.po.PatentVo;
import com.smg.ssm.service.PatentService;

/**
 * <p>Title: PatentServiceImpl</p>
 * <p>Description: 专利服务接口实现类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月17日 下午10:52:09
 * @version 1.0
 */
public class PatentServiceImpl implements PatentService {
	
	@Autowired
	private PatentMapper patentMapper;
	
	@Autowired
	private PatentMapperCustom patentMapperCustom;
	
	/**(non-Javadoc)
	 * <p>Title: addPatent</p>
	 * <p>Description: 添加专利</p>
	 * @param patent
	 * @return int
	 * @see com.smg.ssm.service.PatentService#addPatent(com.smg.ssm.po.Patent)
	 */
	@Override
	public int addPatent(Patent patent) {
		if(patent == null) {
			return 0;
		}
		//状态1是待审核
		patent.setPatentState(2);
		return patentMapper.insert(patent);
	}
	
	/**(non-Javadoc)
	 * <p>Title: deletePatent</p>
	 * <p>Description: 删除专利</p>
	 * @param patentId
	 * @return int
	 * @see com.smg.ssm.service.PatentService#deletePatent(java.lang.String)
	 */
	@Override
	public int deletePatent(String patentId) {
		if(patentId == null) {
			return 0;
		}
		return patentMapper.deleteByPrimaryKey(patentId);
	}
	
	/**(non-Javadoc)
	 * <p>Title: selectMyPatent</p>
	 * <p>Description: 查询自己的专利</p>
	 * @param patentPatentee
	 * @return List<PatentCustom>
	 * @see com.smg.ssm.service.PatentService#selectMyPatent(java.lang.Integer)
	 */
	@Override
	public List<PatentCustom> selectMyPatent(Integer patentPatentee) {
		// TODO Auto-generated method stub
		if(patentPatentee == null) {
			return null;
		}
		List<PatentCustom> patentList = patentMapperCustom.selectMyPatent(patentPatentee);
		return patentList;
	}
	
	/**(non-Javadoc)
	 * <p>Title: selectPatentList</p>
	 * <p>Description: 查询专利集合</p>
	 * @param patentVo
	 * @return List<PatentCustom>
	 * @see com.smg.ssm.service.PatentService#selectPatentList(com.smg.ssm.po.PatentVo)
	 */
	@Override
	public List<PatentCustom> selectPatentList(PatentVo patentVo) {
		List<PatentCustom> patentList= patentMapperCustom.selectPatentList(patentVo);
		return patentList;
	}

	/**(non-Javadoc)
	 * <p>Title: updatePatent</p>
	 * <p>Description: 更新专利</p>
	 * @param patent
	 * @return int
	 * @see com.smg.ssm.service.PatentService#updatePatent(com.smg.ssm.po.Patent)
	 */
	@Override
	public int updatePatent(Patent patent) {
		if(patent == null) {
			return 0;
		}
		patent.setPatentState(1);
		return patentMapper.updateByPrimaryKey(patent);
	}
}
