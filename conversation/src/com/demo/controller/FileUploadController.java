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
	
	private FileUploadService fuleUploadService;
	@RequestMapping(value="/uploadFile", method = RequestMethod.POST)
	@ResponseBody
	public String handleUploadFile(@RequestParam("file") CommonsMultipartFile file) {
		System.out.println("handleUploadFile");
		if (!file.isEmpty()) {
			String path = this.servletContext.getRealPath("/upload/"); // 获取本地存储路径
			System.out.println(path);
			String fileName = file.getOriginalFilename();
			String fileType = fileName.substring(fileName.lastIndexOf("."));
			System.out.println(fileName);
			System.out.println(fileType);
			File file2 = new File(path, new Date().getTime() + fileType); // 新建一个文件
			try {
				file.getFileItem().write(file2); // 将上传的文件写入新建的文件中
			} catch (Exception e) {
				e.printStackTrace();
			}
			return "upload file successfully";
		} else {
			return "upload file error";
		}
	}
}
