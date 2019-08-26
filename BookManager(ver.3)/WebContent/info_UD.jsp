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
<title>Book information</title>
</head>
<body>
	<h1>[도서]Book Title</h1>
	<form action = "/bookManager/Update.do" method = "post">
		도서 번호 : 00-0000<br><br><!-- 임의 숫자 생성 js 필요 -->
		저       자 : <input type = "text" name = "Bauth_info" value = "db 저자"><br><br>
		출  판  사 : <input type = "text" name = "Bpub_info" value = "db 출판사"><br><br>
		상세 설명 : <input type = "text" name = "Binf_info" value = "db 상세설명"><br><br>
		<input type = "button" name = "Bupdate" value = "도서정보 수정">
		<input type = "button" name = "Bdelete" value = "도서 삭제"><br><br>
	</form>
	<form action = "/bookManager/Back.do" method = "post">
		<input type = "button" name = "btn_Back" value = "back">
	</form>
</body>
</html>