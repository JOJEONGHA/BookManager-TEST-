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
<title>Author information</title>
<script type="text/javascript">
	var enroll = document.enroll;
	var exiOk = enroll.exiOK.value;
		if( exiOk == false)
			alert("Already exist!!")
</script>
</head>
<body>
	<form name = "enroll" action="/bookmanager/controller/CreateAuthor.do" method="post">
		작가 이름 : <input type="text" name="name_author"><br>
		<br><br>
		<br> 출신 년월 : <input type="text" name="birth_author">
		<font color="#FF0000">*</font> ex) 1992년 4월 12일 -> 19920412 <br>
		<input type= "hidden" name = "exiOK" value = ${exi}>
		<input type="hidden" name="btn_createA" value="second"> 
		<input type="submit" value="추가">
	</form>
	<form action="/bookmanager/controller/Back.do" method="post">
		<input type="submit" name="btn_Back" value="back">
	</form>
</body>
</html>