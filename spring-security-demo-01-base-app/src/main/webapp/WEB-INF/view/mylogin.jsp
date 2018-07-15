<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form"  prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags"  prefix="security" %>
<html>
<head>
<title>傻瓜steam云挂卡</title>
    
	<meta name="description" content="傻瓜steam云挂卡帮您轻松获得Steam集换式卡牌">
    <meta name="keywords" content="傻瓜steam云挂卡,steam云挂卡,steam挂游戏时间">
    <meta name="content-type" content="text/html; charset=utf-8">
 
   <link type="text/css"
		  rel="stylesheet"
		  href="https://www.sshome.info/5.css" />
		  
   <link rel="shortcut icon" href="6.ico" />


</head>
<body>
<h3>steam挂机系统</h3>
<form:form action="${pageContext.request.contextPath}/process" method="POST">
<c:if test="${prama.error!=null}"><i>
对不起,用户名或密码不正确,请重新输入 !
</i>
</c:if>
<c:if test="${prama.logout!=null}"><i>
你已经登出系统 !
</i>
</c:if>
<p>
卡号<input type="text" name="username">
</p>
<p>
卡密<input type="password" name="password">
</p>
<input type="submit" value="登陆">
</form:form>

</body>

</html>