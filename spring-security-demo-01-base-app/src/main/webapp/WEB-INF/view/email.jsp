<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security" %>



<html>
  <head>
<link type="text/css"
		  rel="stylesheet"
		  href="https://www.sshome.info/5.css" />
  </head>
  
  <body>
  <h4>邮箱用户专用</h4>
    <hr>
     <form:form action="${pageContext.request.contextPath}/email/sentemailcode" method="post">
    <input type="text" name="systemusername" value="<security:authentication property="principal.username"/>" hidden="hidden">
       <input type="submit" value="点此发送一次性邮箱验证码至您的邮箱">
    </form:form>   
       <br><br>
       
    <form:form action="${pageContext.request.contextPath}/email/emailcode" method="post" modelAttribute="bb">
    <input type="text" name="systemusername" value="<security:authentication property="principal.username"/>" hidden="hidden">
    邮箱验证码(请检查你steam邮箱!)<form:input path="emailcode"/>
    <form:errors path="emailcode"></form:errors>
    <br>
    <input type="submit" value="确认">
    </form:form>
<hr>
<a href="${pageContext.request.contextPath}">返回主页面</a>
   
    <hr>
    <form:form action="${pageContext.request.contextPath}/mylogout" method="POST">
    <input type="submit" value="登出系统">
    </form:form>
  </body>
</html>
