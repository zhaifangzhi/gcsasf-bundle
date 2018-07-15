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
<h4>强制挂机命令已送达服务器,1分钟之内没反应,请检查并重新输入</h4>
   <hr>
<a href="${pageContext.request.contextPath}">返回主页面</a>
<hr>
    <form:form action="${pageContext.request.contextPath}/mylogout" method="POST">
    <input type="submit" value="登出系统">
    </form:form>
  </body>
</html>
