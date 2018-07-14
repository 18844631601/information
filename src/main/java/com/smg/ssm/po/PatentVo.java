package com.smg.ssm.po;

import java.util.List;

/**
 * <p>Title: PatentVo</p>
 * <p>Description: 专利封装类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年7月7日 上午8:47:18
 * @version 1.0
 */
public class PatentVo {
    
	private PatentCustom patentCustom;

	private List<PatentCustom> patentCustomList;

	public PatentCustom getPatentCustom() {
		return patentCustom;
	}

	public List<PatentCustom> getPatentCustomList() {
		return patentCustomList;
	}

	public void setPatentCustom(PatentCustom patentCustom) {
		this.patentCustom = patentCustom;
	}
	
	public void setPatentCustomList(List<PatentCustom> patentCustomList) {
		this.patentCustomList = patentCustomList;
	}
	
}