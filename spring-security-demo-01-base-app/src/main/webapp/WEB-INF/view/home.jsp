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
    <h2>steam挂机系统 V1.0</h2><br>
    <br>
    <h4>上传或更新bot至服务器,页面会有30秒左右的载入时间,请耐心等待并保持网络畅通 (注意:一张卡仅能上传一个bot,上传新的bot会自动替换旧的bot)</h4><br>
    <form:form action="${pageContext.request.contextPath}/upload" method="post" modelAttribute="ss">
    <input type="text" name="systemuser" value="<security:authentication property="principal.username"/>" hidden="hidden">
    <input type="text" name="authority" value="<security:authentication property="principal.authorities"/>" hidden="hidden">
    steam用户名<form:input path="username"/>
    <form:errors path="username"></form:errors>
    <br>
    steam登陆密码<form:password path="password"/>
    <form:errors path="password"></form:errors>
    <br>
        当前的手机验证码或者手机令牌验证码 (没有则不填)<form:input path="facode"/>
        <form:errors path="facode"></form:errors><br><br>
        输入默认想挂的游戏appid,如有多个,以空格分隔(功能:增加游戏时间)(没有则不填)<br>
    <form:input path="gamesPlayedWhileIdle"/>
    <form:errors path="gamesPlayedWhileIdle"></form:errors> 
     如何找到appid?请点击此<a href="${pageContext.request.contextPath}/findappid">教程 </a>   
     <br><br>       
    <input type="submit" value="点击将资料提交给服务器进行挂卡">
    </form:form>
    
    <br><h5>采用邮箱验证的用户除上述步骤外,还需进入<a href="${pageContext.request.contextPath}/email/email">此页面</a>进行额外步骤才能开始挂机!</h5>
    
    <hr>
    <h4>此板块为你有激活的bot并正在挂机才会生效 !</h4>
    <form:form action="${pageContext.request.contextPath}/play" method="post">
    <input type="text" name="systemusername" value="<security:authentication property="principal.username"/>" hidden="hidden">
    <input type="text" name="forceappid">
    <input type="submit" value="输入单一且仅限单一游戏的appid以强制开始挂某一游戏(脱离自动挂机模式)">   
    </form:form><br>
    <form:form action="${pageContext.request.contextPath}/resume" method="post">
    <input type="text" name="systemusername" value="<security:authentication property="principal.username"/>" hidden="hidden">
    <br>
    <input type="submit" value="不想强制返回自动挂机模式点此">
    </form:form>
    <hr>
        <h4>如遇断线(steam网络抽风或系统升级维护)请在此输入手机令牌(邮箱验证的用户请点击上步的<a href="${pageContext.request.contextPath}/email/email">此页面</a>)
        </h4>
    <form:form action="${pageContext.request.contextPath}/recover" method="post">
    <input type="text" name="systemusername" value="<security:authentication property="principal.username"/>" hidden="hidden">
    <br>
    <input type="text" name="facode">
    <input type="submit" value="点击以恢复挂机"> 
    </form:form>    
    <hr> 
    <form:form action="${pageContext.request.contextPath}/delete" method="post">
    <input type="text" name="systemusername" value="<security:authentication property="principal.username"/>" hidden="hidden">
    <br>
    <input type="submit" value="点击确定删除现有的bot"> 此功能对游戏中互踢的现象也有用(游戏后重新回到第一步上传bot又可恢复挂机)或者不想挂了
    </form:form>
    <br>
    <hr>
    <form:form action="${pageContext.request.contextPath}/mylogout" method="POST">
    <input type="submit" value="登出系统">
    </form:form>
    <security:authorize access="hasRole('ss')">
    <form action="${pageContext.request.contextPath}/search" method="get" target="_blank">
    搜索资源<input type="text" name="ii" >
    <input type="submit" value="搜寻">
    </form>
    </security:authorize>
  </body>
</html>
