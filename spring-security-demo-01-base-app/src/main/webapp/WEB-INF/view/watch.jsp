<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
  <head>
    <title>blob info</title>

    <script type="text/javascript">
    
    function a(){
	document.gf.submit();
     
}
    </script>
    <link type="text/css"
		  rel="stylesheet"
		  href="https://www.sshome.info/5.css" />
		  
  </head>
  
  <body>
<video width=800px height=600px controls autoplay loop>
<source src="https://storage.googleapis.com/fzlove/${param.ff}" type="video/mp4">
<track kind="subtitles" src="https://www.sshome.info/${qq}" label="字幕" default></track>
</video> 
  </body>
</html>

