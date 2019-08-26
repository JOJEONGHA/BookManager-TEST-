<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%request.setCharacterEncoding("utf-8"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book create</title>
</head>
<body>
	<form action = "/bookManager/controller/Enroll.do" method = "post">
		작가 이름 : <input type = "text" name = "Aname_enroll" ><br><br>
		출생 년도 : <input type = "text" name = "Abirth_enroll"><br><br>
		<input type = "submit" name = "Acreate" value = "작가 추가"><br><br>
	</form>
	<form action = "/bookManager/controller/Back.do" method = "post">
		<input type = "button" name = "btn_Back" value = "back">
	</form>
</body>
</html>