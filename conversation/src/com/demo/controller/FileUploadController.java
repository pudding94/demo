package com.demo.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.ServletContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.demo.service.FileUploadService;

@Controller
@RequestMapping("/upload")
public class FileUploadController implements ServletContextAware {
	private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext context) {
		System.out.println(context);
		// TODO Auto-generated method stub
		this.servletContext=context;
	}
	
	private FileUploadService fileUploadService;
	@RequestMapping(value="/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String handleUploadFile(@RequestParam("filetest") CommonsMultipartFile filetest) {
		System.out.println("handleUploadFile");
		String path = this.servletContext.getRealPath("/upload/"); // 获取本地存储路径
		System.out.println(path);

		String filetestName = filetest.getOriginalFilename();
		
		String imagePath = "d:\\test\\lib\\";
		imagePath = "C:\\Documents and Settings\\wangzhaod\\git\\demo\\conversation\\WebContent\\WEB-INF\\lib\\";
		//File filetesttemp = new File(path, new Date().getTime() + filesrcType); // 新建一个文件
		File filetesttemp = new File(imagePath + filetestName);
		try {
			filetest.getFileItem().write(filetesttemp); // 将上传的文件写入新建的文件中
		} catch (Exception e) {
			e.printStackTrace();
			return "upload file error";	
		}
		
		System.out.println(filetesttemp.getPath()+"=="+filetesttemp.getName());
		return "upload file successfully";	
			
	}
	
	/*
	private FileUploadService fileUploadService;
	@RequestMapping(value="/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String handleUploadFile(@RequestParam("filesrc") CommonsMultipartFile filesrc,@RequestParam("filetest") CommonsMultipartFile filetest) {
		System.out.println("handleUploadFile");
		if (!filesrc.isEmpty()) {
			String path = this.servletContext.getRealPath("/upload/"); // 获取本地存储路径
			System.out.println(path);
			String filesrcName = filesrc.getOriginalFilename();
			String filetestName = filetest.getOriginalFilename();
			String filesrcType = filesrcName.substring(filesrcName.lastIndexOf("."));
			String filetestType = filetestName.substring(filesrcName.lastIndexOf("."));
			System.out.println("srcname"+filesrcName);
			System.out.println("testname"+filetestType);
			String imagePath = "C:\\Documents and Settings\\wangzhaod\\git\\demo\\conversation\\WebContent\\WEB-INF\\lib";
			File filesrctemp = new File(path, new Date().getTime() + filesrcType); // 新建一个文件
			//File filetesttemp = new File(path, new Date().getTime() + filesrcType); // 新建一个文件
			File filetesttemp = new File(imagePath);
			try {
				filesrc.getFileItem().write(filesrctemp); // 将上传的文件写入新建的文件中
				filetest.getFileItem().write(filetesttemp); // 将上传的文件写入新建的文件中
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println(filetesttemp.getPath()+"=="+filetesttemp.getName());
			return "upload file successfully";
		} else {
			return "upload file error";
		}
	}
	*/
}
