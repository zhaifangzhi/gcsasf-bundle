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
  <hr>
     <br>
<span>邮箱验证码已发送 ！请检查steam绑定的邮箱. 并在3分钟之内返回<a href="${pageContext.request.contextPath}">主页面</a>并输入刚获得的验证码</span>
   <hr>
<a href="${pageContext.request.contextPath}">返回主页面</a>
<hr>
    <form:form action="${pageContext.request.contextPath}/mylogout" method="POST">
    <input type="submit" value="登出系统">
    </form:form>
  </body>
</html>
