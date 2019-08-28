<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<<script type="text/javascript">
	var bookinfo = document.getPar
</script>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Book information</title>
</head>
<body>
	<h1>[도서]${bookInfo.title}</h1>
	
	저       자 : <input type = "text" name = "Bauth_info" value = "${bookInfo.authorname}"><br><br>
	출  판  사 : <input type = "text" name = "Bpub_info" value = "${bookInfo.publisher}"><br><br>
	상세 설명 : <input type = "text" name = "Binf_info" value = "${bookInfo.summary}"><br><br>
	
	<form action = "/bookmanager/controller/update.do" method = "post">
		<input type = "hidden" name = "btnInfo" value = "update">
		<input type = "submit" name = "Bupdate" value = "도서정보 수정">
	</form>
	<form action = "/bookmanager/controller/update.do" method = "post">
		<input type= "hidden" name = "bookinfo" value = "${bookInfo.booknum}">
		<input type = "hidden" name = "btnInfo" value = "delete">
		<input type = "submit" name = "Bdelete" value = "도서 삭제"><br><br>
	</form>
	<form action = "/bookmanager/controller/Back.do" method = "post">
		<input type = "submit" name = "btn_Back" value = "back">
	</form>
</body>
</html>