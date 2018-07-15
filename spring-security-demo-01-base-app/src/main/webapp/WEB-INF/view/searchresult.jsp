<%@page import="java.security.Timestamp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <title>blob info</title>
	<jsp:useBean id="dateValue" class="java.util.Date"/>
	
    <link type="text/css"
		  rel="stylesheet"
		  href="https://www.sshome.info/5.css" />
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
  </head>
  
  <body>
    <table>
    <tr><th>结果</th><th>上传日期</th><th>删除</th><th>上传字幕</th></tr>
    <c:forEach var="temp" items="${ss}">
    <tr>
    <td><a href="${pageContext.request.contextPath}/watch?ff=${temp.name}" target="_blank">${temp.name}</a></td><td><jsp:setProperty name="dateValue" property="time" value="${temp.createTime}"/><fmt:formatDate value="${dateValue}" pattern="yyyy-MM-dd HH:mm:ss"/> </td>
    
    <td>
    <form id="sl" name="gf" action="${pageContext.request.contextPath}/deleteblob" method="get" >
    <input type="text" name="ff" value="${temp.name}" hidden="hidden">
    <input type="text" name="ii" value="${param.ii}" hidden="hidden">
    <input type="submit" value="删除此资源" ></form> 
    </td>
    
    <td>
    <form id="upload" 
    action="${pageContext.request.contextPath}/handleservlet?${_csrf.parameterName}=${_csrf.token}"
    enctype="multipart/form-data" method="post">       
         <input type="text" name="aa" value="${temp.name}" hidden="hidden"/>
         <input type="text" name="ii" value="${param.ii}" hidden="hidden"/>
         <input type="file" name="file" />
         <input type="submit" value="上传字幕">
     </form>
    </td>
    </tr>
    </c:forEach>
    </table>

  </body>
</html>

