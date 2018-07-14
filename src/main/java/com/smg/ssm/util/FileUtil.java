package com.smg.ssm.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

/**
 * <p>Title: FileUtil</p>
 * <p>Description: 文件IO工具</p>
 * <p>Company: www.ssmmgg.club</p>
 * @author 曾辉
 * @date 2018年6月24日 下午2:45:36
 * @version 1.0
 */
public class FileUtil {
	
	/**
	 * <p>Title: selectPaperContent</p>
	 * <p>Description: 查看论文内容</p>
	 * @param response
	 * @param fileName
	 * @param fileName2 
	 * @throws Exception
	 */
	public static void selectPaperContent(HttpServletResponse response, String fileName) throws Exception{
		response.setContentType("text/html; charset=UTF-8");
        String filePath = "D:\\develop\\upload\\temp\\"+fileName;
        if(!"".equals(filePath)) {
            /*1)根据项目所在的服务器环境,确定路径中的 /  和 \ */
            String osName = System.getProperty("os.name");
            if (Pattern.matches("Linux.*", osName)) {
                filePath = "/" + filePath.replace("\\","/");
            } else if(Pattern.matches("Windows.*", osName)) {
                filePath.replace("/","\\");
            }

            /*2)获得文件名后缀*/
            String ext = "";
            if(!"".equals(fileName) && fileName.contains(".")){
                ext = fileName.substring(fileName.lastIndexOf(".") + 1, fileName.length()).toUpperCase();
            }

            /*3)根据文件类型不同进行预览*/
            /*预览图片*/
            if ("PNG".equals(ext) || "JPEG".equals(ext) || "JPG".equals(ext)) {
                response.setContentType("image/jpeg");
            }
            /*预览BMP格式的文件*/
            if ("BMP".equals(ext)) {
                response.setContentType("image/bmp");
            }
            /*预览pdf*/
            if ("PDF".equals(ext)) {
                response.setContentType("application/pdf");
            }

            /*利用openOffice将office文件转换为pdf格式, 然后预览doc, docx, xls, xlsx, ppt, pptx */
            if ("DOC".equals(ext) || "DOCX".equals(ext) || "XLS".equals(ext) || "XLSX".equals(ext) || "PPT".equals(ext) || "PPTX".equals(ext)) {
                /*filePath在数据库中是不带文件后缀的, 由于jodConverter必须要识别后缀,所以将服务器中的文件重命名为带后缀的文件*/
                File docFile = new File(filePath);
                /*File docFileWithExt = new File(filePath + "." + ext.toLowerCase()); //带后缀的文件
                docFile.renameTo(docFileWithExt);
                */
                /*转换之后的文件名*/
                File pdfFile;
                if(filePath.contains(".")){
                    pdfFile = new File(filePath.substring(0, filePath.lastIndexOf(".")) + ".pdf");
                }else{
                    pdfFile = new File(filePath + ".pdf");
                }

                /*判断即将要转换的文件是否真实存在*/
                if (docFile.exists()) {
                    /*判断改文件是否已经被转换过,若已经转换则直接预览*/
                    if (!pdfFile.exists()) {
                        /*打开OpenOffice连接,*/
                        OpenOfficeConnection connection = new SocketOpenOfficeConnection(8100);
                        try {
                            connection.connect();
                            DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
                            converter.convert(docFile, pdfFile);
                            connection.disconnect();

                            filePath = pdfFile.getPath(); //文件转换之后的路径
                            response.setContentType("application/pdf");

                        } catch (java.net.ConnectException e) {
                            e.printStackTrace(); //openoffice 服务未启动
                            throw e;
                        } catch (com.artofsolving.jodconverter.openoffice.connection.OpenOfficeException e) {
                            e.printStackTrace(); //读取转换文件失败
                            throw e;
                        } catch (Exception e) {
                            e.printStackTrace();
                            throw e;
                        }finally { //发生exception时, connection不会自动切断, 程序会一直挂着
                            try{
                                if(connection != null){
                                    connection.disconnect();
                                    connection = null;
                                }
                            }catch(Exception e){}
                        }
                    } else {
                        filePath = pdfFile.getPath(); //文件已经转换过
                        response.setContentType("application/pdf");
                    }
                } else {
                	response.getWriter().println(
                			"<div style='width:100%;height:50px;text-align:center;margin:auto;line-height:50px; font-size:30px;background:#CDCDCD'>"
                			+ "需要预览的文档在服务器中不存在!</div>");
                    return;
                }
            }
            /*输入流将磁盘文件读入内存，内存传入缓存，缓存写入输出流,显示在界面上,实现预览效果*/
            FileInputStream fis = new FileInputStream(filePath);
            OutputStream os = response.getOutputStream();
            try {
                int count = 0;
                byte[] buffer = new byte[1024 * 1024];
                while ((count = fis.read(buffer)) != -1)
                    os.write(buffer, 0, count);
                os.flush();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (os != null)
                    os.close();
                if (fis != null)
                    fis.close();
            }
        }
		return;
	}
	
	/**
	 * <p>Title: uploadFile</p>
	 * <p>Description: 上传文件</p>
	 * @param file
	 * @param newFilename
	 * @throws Exception
	 */
	public static void uploadFile(MultipartFile file, String newFilename) throws Exception {
		String file_path = "D:\\develop\\upload\\temp\\";
		File newFile = new File(file_path+newFilename);
		file.transferTo(newFile); //将文件从内存写入磁盘
	}
	
	/**
	 * <p>Title: deleteFile</p>
	 * <p>Description: 删除文件</p>
	 * @param fileName
	 * @return
	 * @throws Exception
	 */
	public static Boolean deleteFile(String fileName) throws Exception {
		//图片物理路径
		String file_path = "D:\\develop\\upload\\temp\\";
		//新图片文件
		File newFile = new File(file_path+fileName);
		if(newFile.exists()){
			Boolean result=newFile.delete();
			System.out.println(result);
			return result;
		}
		return false;
	}
	
	/**
	 * <p>Title: chargeFile</p>
	 * <p>Description: 判断文件格式</p>
	 * @param file
	 * @return
	 * @throws Exception
	 */
	public static boolean chargeFile(MultipartFile file) throws Exception{
		String originalFilename = file.getOriginalFilename();
		Pattern pattern = Pattern.compile("\\.(doc)|(docx)|(pdf)");
		Matcher matcher = pattern.matcher(originalFilename);
		return matcher.find();
	}
	/*
	public static void downloadImg(String imgsrc,String targetPath){
		try {
			//2.生成链接地址对象
			URL url = new URL(imgsrc);
			//3.打开连接    URLConnection
			URLConnection connection = url.openConnection();
			//4.获取输入流并设定一次输入字节大小
			InputStream in = connection.getInputStream();
			byte[] b = new byte[2048];
			int len = 0;
			//5.新建文件输出流并设置存储路径
			FileOutputStream out = new FileOutputStream(targetPath);
			//6.进行读写循环
			while((len = in.read(b)) != -1){
				System.out.println("====="+len);
				out.write(b, 0, len);
			}
			//7.关闭io流
			out.close();
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
