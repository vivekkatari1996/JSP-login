<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate");
response.setHeader("Cache-Control", "no-cache,no-store, must-revalidate");
if(session.getAttribute("username")== null){
	response.sendRedirect("login.jsp");
}

%>
<video src="https://www.youtube.com/watch?v=P33qQO4-b9I&ab_channel=YbrantBhakti" autofocus="autofocus" width="100%" height="100%"></video>
video is playing

</body>
</html>