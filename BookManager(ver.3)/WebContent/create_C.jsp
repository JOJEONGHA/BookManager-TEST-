<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book create</title>
</head>
<body>
	<form action = "/bookmanager/controller/Create.do" method = "post">
		제       목 : <input type = "text" name = "Bname_info" value = "db 책 제목"><br><br>
		저       자 : <input type = "text" name = "Bauth_info" value = "db 저자"><br><br>
		출  판  사 : <input type = "text" name = "Bpub_info" value = "db 출판사"><br><br>
		상세 설명 : <input type = "text" name = "Binf_info" value = "db 상세설명"><br><br>
		<input type = "submit" name = "Bcreate" value = "도서 추가"><br><br>
	</form>
	<form action = "/bookManager/controller/Back.do" method = "post">
		<input type = "button" name = "btn_Back" value = "back">
	</form>
</body>
</html>