<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<html>
  <head>
<link type="text/css"
		  rel="stylesheet"
		  href="https://www.sshome.info/5.css" />
  </head>
  
  <body>
  上传结果
  <hr>
     <br>
     上传手机令牌成功，过30秒如仍无开始挂机，请检查令牌是否正确，并重新输入
   <hr>
<a href="${pageContext.request.contextPath}">返回主页面</a>
<hr>
    <form:form action="${pageContext.request.contextPath}/mylogout" method="POST">
    <input type="submit" value="登出系统">
    </form:form>
  </body>
</html>
