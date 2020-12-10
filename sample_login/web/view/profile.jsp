<%@page import="com.login.entity.login_entity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../menu.jsp" %>
                                                                                                                                                    
	<form name="uploadForm" method="post" action="/insta/upload.do">
		<div>
			<img name="profileimg" src="${logOK.profileimg}">
<!-- 			<td><input type="file" name="file" size=40 value="pro"/></td> -->
		</div>
		<div style="border: 1px solid #48BAE4; height: auto; width: 650px;">
			<img src="/insta/upload/bonobono.jpg" width="200">
			<img src="/insta/upload/bonobono.jpg" width="200">
			<img src="/insta/upload/bonobono.jpg" width="200">
			<img src="/insta/upload/bonobono.jpg" width="200">
			<img src="/insta/upload/bonobono.jpg" width="200">
		</div>
		<tr>
			<input type="submit" value="chk"/>
	    </tr>
	</form>
</body>
</html>