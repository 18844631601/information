package com.smg.ssm.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;
import com.smg.ssm.mapper.PaperMapper;
import com.smg.ssm.mapper.PaperMapperCustom;
import com.smg.ssm.mapper.UserMapper;
import com.smg.ssm.mapper.UserMapperCustom;
import com.smg.ssm.po.Paper;
import com.smg.ssm.po.PaperCustom;
import com.smg.ssm.po.PaperVo;
import com.smg.ssm.po.User;
import com.smg.ssm.po.UserCustom;
import com.smg.ssm.po.UserVo;
import com.smg.ssm.service.PaperService;
import com.smg.ssm.util.FileUtil;

/**
 * <p>Title: PaperServiceImpl</p>
 * <p>Description: 论文服务实现类</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月16日 下午5:06:45
 * @version 1.0
 */
@Service
public class PaperServiceImpl implements PaperService{
	@Autowired
	private PaperMapper paperMapper; 
	@Autowired
	private PaperMapperCustom paperMapperCustom;
	@Autowired
	private UserMapper userMapper;
	@Autowired
	private UserMapperCustom userMapperCustom;

	/**(non-Javadoc)
	 * <p>Title: addPaper</p>
	 * <p>Description: 添加论文</p>
	 * @param paper
	 * @return
	 * @see com.smg.ssm.service.impl.PaperService#addPaper(com.smg.ssm.po.Paper)
	 */
	@Override
	public Integer addPaper(Paper paper, MultipartFile paperFile) {
		User thisUser = userMapper.selectByPrimaryKey(paper.getPaperInstructor());
		if(thisUser == null) {
			return 11;
		}
		thisUser = userMapper.selectByPrimaryKey(paper.getPaperUtterer());
		if(thisUser == null) {
			return 12;
		}
		try {
			if(FileUtil.chargeFile(paperFile)) {
				String paperId = Long.toString(System.currentTimeMillis());
				paper.setPaperId(paperId);
				String paperContent = paper.getPaperContent();
				paperContent = paperId+paperContent.substring(paperContent.indexOf("."));
				FileUtil.uploadFile(paperFile, paperContent);
				paper.setPaperContent(paperContent);
			}else {
				return 13;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		paper.setPaperPublishtime(new Date());
		paper.setPaperState(2);
		return paperMapper.insert(paper);
	}
	
	/**(non-Javadoc)
	 * <p>Title: deletePaper</p>
	 * <p>Description: 删除论文</p>
	 * @param paperId
	 * @return
	 * @see com.smg.ssm.service.impl.PaperService#deletePaper(java.lang.Integer)
	 */
	@Override
	public Integer deletePaper(String paperId) {
		String paperContent = paperMapperCustom.selectPaperContent(paperId);
		try {
			FileUtil.deleteFile(paperContent);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return paperMapper.deleteByPrimaryKey(paperId);
	}
	
	/**(non-Javadoc)
	 * <p>Title: updatePaper</p>
	 * <p>Description: 修改论文</p>
	 * @param paper
	 * @return
	 * @see com.smg.ssm.service.impl.PaperService#updatePaper(com.smg.ssm.po.Paper)
	 */
	@Override
	public Integer updatePaper(Paper paper,  MultipartFile paperFile) {
		try {
			if(FileUtil.chargeFile(paperFile)) {
				String paperContent = paper.getPaperContent();
				paperContent = paper.getPaperId()+paperContent.substring(paperContent.indexOf("."));
				FileUtil.deleteFile(paperContent);
				FileUtil.uploadFile(paperFile, paperContent);
				paper.setPaperContent(paperContent);
			}else {
				return 13;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
		paper.setPaperPublishtime(new Date());
		paper.setPaperState(0);
		return paperMapper.updateByPrimaryKey(paper);
	}
	
	/**(non-Javadoc)
	 * <p>Title: updatePaperReason</p>
	 * <p>Description: 更新论文原因</p>
	 * @param paperContent
	 * @param paperReason
	 * @return
	 * @see com.smg.ssm.service.PaperService#updatePaperReason(java.lang.String, java.lang.String)
	 */
	public Integer updatePaperReason(String paperId, String paperReason) {
		Paper paper = new Paper();
		paper.setPaperId(paperId);
		paper.setPaperReason(paperReason);
		Integer result = paperMapperCustom.updatePaperReason(paper);
		return result;
	}
	
	/**(non-Javadoc)
	 * <p>Title: updatePaperState</p>
	 * <p>Description: 更新论文你状态为通过</p>
	 * @param paperId
	 * @param state
	 * @return
	 * @see com.smg.ssm.service.PaperService#updatePaperState(java.lang.Integer)
	 */
	public Integer updatePaperState(String paperId, Integer state) {
		Paper paper = new Paper();
		paper.setPaperId(paperId);
		paper.setPaperState(state);
		if(state == 1 || state == 2) {
			return paperMapperCustom.updatePaperState(paper);
		}else {
			return 0;
		}
	}
	
	/**(non-Javadoc)
	 * <p>Title: selectPaper</p>
	 * <p>Description: 查询单个论文</p>
	 * @param paperId
	 * @return
	 * @see com.smg.ssm.service.impl.PaperService#selectPaper(java.lang.String)
	 */
	@Override
	public Paper selectPaper(String paperId) {
		return paperMapper.selectByPrimaryKey(paperId);
	}

	/**(non-Javadoc)
	 * <p>Title: selectPaperList</p>
	 * <p>Description: 查询论文集合</p>
	 * @param index
	 * @param selectString
	 * @return
	 * @throws Exception
	 * @see com.smg.ssm.service.PaperService#selectPaperList(java.lang.Integer, java.lang.String)
	 */
	@Override
	public List<PaperCustom> selectPaperList(Integer index, String selectString) throws Exception{
		List<PaperCustom> paperCustomList = new ArrayList<PaperCustom>();
		List<PaperCustom> paperCustomList1 = new ArrayList<PaperCustom>();
		PaperCustom paperCustom = new PaperCustom();
		PaperVo paperVo = new PaperVo();
		UserCustom userCustom = new UserCustom();
		UserVo userVo = new UserVo();
		int flag = 0;
		switch(index) {
			case 1:
				paperCustom.setPaperKeywords(selectString);break;
			case 2:
				paperCustom.setPaperId(selectString);break;
			case 3:
				switch(selectString) {
					case "设计":index = 1;break;
					case "学术":index= 2;break;
					default:return paperCustomList;
				}
				paperCustom.setPaperType(index);break;
			case 4:
				userCustom.setUserType(2);
				userCustom.setUserName(selectString);
				userVo.setUserCustom(userCustom);
				List<UserCustom> userCustomList = userMapperCustom.selectUserList(userVo);
				for(UserCustom userCustom1 : userCustomList) {
					paperCustom.setPaperInstructor(userCustom1.getUserId());
					paperVo.setPaperCustom(paperCustom);
					paperCustomList.addAll(paperMapperCustom.selectPaperList(paperVo));
				} 
				flag = 1; break;
			case 5:
				SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date newDate = new Date();
				try {
					newDate= simpleDateFormat.parse(selectString);
				} catch (Exception e) {
					e.printStackTrace();
					return paperCustomList;
				};
				paperCustom.setPaperPublishtime(newDate);break;
			case 6:
				userCustom.setUserType(1);
				userCustom.setUserName(selectString);
				userVo.setUserCustom(userCustom);
				List<UserCustom> userCustomList1 = userMapperCustom.selectUserList(userVo);
				for(UserCustom userCustom1 : userCustomList1) {
					paperCustom.setPaperUtterer(userCustom1.getUserId());
					paperVo.setPaperCustom(paperCustom);
					paperCustomList.addAll(paperMapperCustom.selectPaperList(paperVo));
				}
				flag = 1; break;
			default:return paperCustomList;
		}
		if(flag == 0) {
			paperVo.setPaperCustom(paperCustom);
			paperCustomList = paperMapperCustom.selectPaperList(paperVo);
		}
		for(PaperCustom paperCustom1:paperCustomList) {
			paperVo.setPaperCustom(paperCustom1);
			paperCustom1 = paperMapperCustom.selectPaperName(paperVo);
			paperCustomList1.add(paperCustom1);
		}
		return paperCustomList1;
	}

	/**(non-Javadoc)
	 * <p>Title: selectMyPaper</p>
	 * <p>Description: 查询自己论文</p>
	 * @param paperUtterer
	 * @return
	 * @see com.smg.ssm.service.PaperService#selectMyPaper(java.lang.Integer)
	 */
	@Override
	public List<PaperCustom> selectMyPaper(Integer paperUtterer) {
		
		List<PaperCustom> paperCustomList = paperMapperCustom.selectMyPaper(paperUtterer);
		List<PaperCustom> paperCustomList1 = new ArrayList<PaperCustom>();
		PaperVo paperVo = new PaperVo();
		for(PaperCustom paperCustom1:paperCustomList) {
			paperVo.setPaperCustom(paperCustom1);
			paperCustom1 = paperMapperCustom.selectPaperName(paperVo);
			paperCustomList1.add(paperCustom1);
		}
		return paperCustomList1;
	}

	/**(non-Javadoc)
	 * <p>Title: selectPaperContent</p>
	 * <p>Description: </p>
	 * @param response
	 * @param fileName
	 * @return
	 * @see com.smg.ssm.service.PaperService#selectPaperContent(javax.servlet.http.HttpServletResponse, java.lang.String)
	 */
	@Override
	public void selectPaperContent(HttpServletResponse response, String fileName) {
		try {
			FileUtil.selectPaperContent(response, fileName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**(non-Javadoc)
	 * <p>Title: selectPaperState</p>
	 * <p>Description: 根据论文名查状态</p>
	 * @param paperContent
	 * @return
	 * @see com.smg.ssm.service.PaperService#selectPaperState(java.lang.String)
	 */
	@Override
	public Integer selectPaperState(String paperContent) {
		return paperMapperCustom.selectPaperState(paperContent);
	}

}
