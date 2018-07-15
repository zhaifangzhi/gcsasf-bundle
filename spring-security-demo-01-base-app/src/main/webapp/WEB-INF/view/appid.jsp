<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link type="text/css"
		  rel="stylesheet"
		  href="https://www.sshome.info/5.css" />
  </head>
  
  <body>
    1.请先打开网页steam <br>

2.打开你要挂游戏时间的游戏的商店页面
浏览器url地址栏上跟在"app/"后面用红笔标注的数字即是特定游戏的appid<br><br>
<img src="https://storage.googleapis.com/fzlove/pic/kk.JPG" alt="appid" />
<a href="${pageContext.request.contextPath}">返回主页面</a>
<hr>
<form:form action="${pageContext.request.contextPath}/mylogout" method="POST">
    <input type="submit" value="登出系统">
    </form:form>
</body>
</html>
