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
	<link rel="stylesheet" type="text/css" href="css/user.css" />
	<script type="text/javascript" src="js/user.js"></script>
<title>user</title>
</head>
<body>
	this is user.jsp</br>
	id:<input id="userId" type="text"/></br>
	<input id="userLoad" type="button" value="load"></br>
	name:<input id="userName" type="text"/></br>
	<input id="userSave" type="button" value="save"></br>
</body>
</html>