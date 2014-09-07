<%@ page language="java" import="java.util.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<base href="<%=basePath%>">
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- 	<script type="text/javascript" src="lib/jquery/jquery-1.11.1.min.js"></script> -->
	<script type="text/javascript" src="lib/jquery/jquery-1.11.1.js"></script>
<!-- 	<link rel="stylesheet" type="text/css" href="css/user.css" /> -->
	<script type="text/javascript" src="lib/jquery/ajaxfileupload.js"></script>
		<script type="text/javascript" src="js/fileupload.js"></script>
<title>fileupload</title>
</head>
<body>
		<form action="upload/uploadFile"  method="post" enctype="multipart/form-data">
			<input id="file" type="file" name="file" /></br>
			Form submit:<input type="submit" /></br>
			Ajax submit:<input id="uploadFile" type="button" value="submit"></br>
		</form>
</body>
</html>