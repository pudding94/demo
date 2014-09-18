package com.demo.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import javax.servlet.ServletContext;

import junit.framework.TestCase;
import junit.framework.TestResult;

import org.junit.internal.JUnitSystem;
import org.junit.internal.RealSystem;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.demo.po.ResultInfo;
import com.demo.service.FileUploadService;

@Controller
@RequestMapping("/test")
public class JUnitTestExecutorController implements ServletContextAware{
	private ServletContext servletContext;
	@Override
	public void setServletContext(ServletContext context) {
		System.out.println(context);
		// TODO Auto-generated method stub
		this.servletContext=context;
	}
	
	
	// private FileUploadService fuleUploadService;
	@RequestMapping(value="/junittest")
	@ResponseBody
	public ResultInfo handleUploadFile(@RequestBody String testType) throws Exception {
		System.out.println("handleUploadFile");
//		String path = this.servletContext.getRealPath("/upload/"); // 获取本地存储路径
//		String path = "C:\Documents and Settings\wangzhaod\git\demo\conversation\WebContent\WEB-INF\lib";
//		System.out.println(path);
//		String filesrcName = filesrc.getOriginalFilename();
//		String filetestName = filetest.getOriginalFilename();
//		String filesrcType = filesrcName.substring(filesrcName.lastIndexOf("."));
//		String filetestType = filetestName.substring(filesrcName.lastIndexOf("."));
//		System.out.println("srcname"+filesrcName);
//		System.out.println("testname"+filetestType);
//		File filesrcnew = new File(path, new Date().getTime() + filesrcType); // 新建一个文件
//		File filetestnew = new File(path, new Date().getTime() + filesrcType); // 新建一个文件
//		try {
////			filesrc.getFileItem().write(filesrcnew); // 将上传的文件写入新建的文件中
//			filetest.getFileItem().write(filetestnew); // 将上传的文件写入新建的文件中
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		System.out.println(filesrcnew);
		String path = "C:\\apache-tomcat-7.0.55\\webapps\\demo\\lib\\test.jar";
		List<String> tests = new ArrayList<String>();
		String testPackagePrefix = "com.demo.test";
		JarFile jarFile = new JarFile("d:\\test\\test.jar");
		Enumeration<JarEntry> entries = jarFile.entries();
		
		while (entries.hasMoreElements()) {
			JarEntry theEntry = entries.nextElement();
			String aTest = theEntry.getName();
			aTest = aTest.replace('/', '.');
			if (aTest.startsWith(testPackagePrefix)) {
				int lastDotIndex = aTest.lastIndexOf('.');
				aTest = aTest.substring(0, lastDotIndex);
				tests.add(aTest);
			}
		}
		
		//JUnitCore.main(tests.toArray(new String[]{}));
		TestResult testCase = new TestResult();
		
		JUnitSystem system = new RealSystem();
		Result result= new JUnitCore().runMain(system, tests.toArray(new String[]{}));
		
		//Result result = new TestExecutor().execute(tests);
		//Result result= new JUnitCore().runMain(system, testArrays);
		int runCount = result.getRunCount();
		int failureCount = result.getFailureCount();
		List<Failure> failures = result.getFailures();
		for (Failure aFailure : failures) {
			String testHeader = aFailure.getTestHeader();
			String message = aFailure.getMessage();
		}
		
		
		ResultInfo resultInfo = new ResultInfo();
		resultInfo.setTestType(testType);
		resultInfo.setFailCount(failureCount);
		resultInfo.setSuccessCount(runCount - failureCount);
		return resultInfo;
		//system.exit(result.wasSuccessful() ? 0 : 1);
		//return "success" + tests;
		
		
	}
	/*
	public String handleUploadFile(@RequestParam("file") CommonsMultipartFile file) throws IOException {
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
			
			path = "D:\\test\\test.jar";
			List<String> tests = new ArrayList<String>();
			String testPackagePrefix = "com.demo.test";
			JarFile jarFile = new JarFile(path);
			Enumeration<JarEntry> entries = jarFile.entries();
			while (entries.hasMoreElements()) {
				JarEntry theEntry = entries.nextElement();
				String aTest = theEntry.getName();
				aTest = aTest.replace('/', '.');
				if (aTest.startsWith(testPackagePrefix)) {
					int lastDotIndex = aTest.lastIndexOf('.');
					aTest = aTest.substring(0, lastDotIndex);
					tests.add(aTest);
				}
			}
			
			//JUnitCore.main(tests.toArray(new String[]{}));
			//JUnitSystem system = new RealSystem();
			Result result= new JUnitCore().runMain(null, tests.toArray(new String[]{}));
			//Result result= new JUnitCore().runMain(system, testArrays);
			int runCount = result.getRunCount();
			int failureCount = result.getFailureCount();
			List<Failure> failures = result.getFailures();
			for (Failure aFailure : failures) {
				String testHeader = aFailure.getTestHeader();
				String message = aFailure.getMessage();
			}
			
			//system.exit(result.wasSuccessful() ? 0 : 1);
		
			return "upload file successfully";
		} else {
			return "upload file error";
		}
	}
	*/
}
