package com.smg.ssm.po;

/**
 * <p>Title: PaperCustom</p>
 * <p>Description: 论文扩展类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月16日 下午7:21:01
 * @version 1.0
 */
public class PaperCustom extends Paper{
	private String paperUttererName;

	private String paperInstructorName;

	public String getPaperUttererName() {
		return paperUttererName;
	}

	public void setPaperUttererName(String paperUttererName) {
		this.paperUttererName = paperUttererName;
	}

	public String getPaperInstructorName() {
		return paperInstructorName;
	}

	public void setPaperInstructorName(String paperInstructorName) {
		this.paperInstructorName = paperInstructorName;
	}
	
}