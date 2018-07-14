package com.smg.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.support.spring.annotation.ResponseJSONP;
import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

@Controller
public class TestController {
	/**
     * 在线预览图片
     * @param request
     * @param response
     * @param filePath
     * @param fileName
     * @throws IOException
     */
    @RequestMapping(value="/seePaper/{fileName}",method=RequestMethod.GET)
    @ResponseJSONP
    public String preview(HttpServletResponse response, @RequestParam String filePath, @RequestParam String fileName) throws IOException {
        Map<String, String> result = new HashMap<String, String>();

        response.setContentType("text/html; charset=UTF-8");
        
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
                	result.put("false", "需要预览的文档在服务器中不存在!");
                    return JSON.toJSONString(result);
                }
            }
            /*将文件写入输出流,显示在界面上,实现预览效果*/
            FileInputStream fis = new FileInputStream(filePath);
            OutputStream os = response.getOutputStream();
            try {
                int count = 0;
                byte[] buffer = new byte[1024 * 1024];
                while ((count = fis.read(buffer)) != -1)
                    os.write(buffer, 0, count);
                os.flush();
                result.put("true", "");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (os != null)
                    os.close();
                if (fis != null)
                    fis.close();
            }
        }
        return JSON.toJSONString(result);
    }
}
