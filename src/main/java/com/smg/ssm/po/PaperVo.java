package com.smg.ssm.po;

import java.util.List;

/**
 * <p>Title: PaperVo</p>
 * <p>Description: 论文包装类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月18日 下午9:06:19
 * @version 1.0
 */
public class PaperVo {
	private Paper paper;

	private PaperCustom paperCustom;
	
	private List<PaperCustom> paperCustomList;
	
	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public PaperCustom getPaperCustom() {
		return paperCustom;
	}

	public void setPaperCustom(PaperCustom paperCustom) {
		this.paperCustom = paperCustom;
	}

	public List<PaperCustom> getPaperCustomList() {
		return paperCustomList;
	}

	public void setPaperCustomList(List<PaperCustom> paperCustomList) {
		this.paperCustomList = paperCustomList;
	}

}
