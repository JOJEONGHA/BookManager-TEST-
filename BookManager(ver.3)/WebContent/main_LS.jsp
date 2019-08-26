<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
  request.setCharacterEncoding("UTF-8");
%>  

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main_LS</title>
</head>
<body>
	<form action="/bookmanager/controller/List.do" method="post">
		<select name='sType'>
			<option value="Binfo">도서 설명</option>
			<option value="Bpub">출 판 사</option>
			<option value="Bnum">도서번호</option>
			<option value="Bauth">저 자</option>
			<option value="Bname" selected="selected">책 제목</option>
		</select> <input type="text" name="bName"> <input type="submit"
			value="search">
	</form>
	<table align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="7%"><b>도서번호</b></td>
			<td width="7%"><b>책 제목</b></td>
			<td width="7%"><b>저 자</b></td>
			<td width="7%"><b>출 판 사</b></td>
		</tr>
		<!-- Print Book List -->
		<c:forEach var="books" items="${booksList}">
			<tr align="center">
				<td>${books.booknum}</td>
				<td>${books.title}</td>
				<td>${books.authorname}</td>
				<td>${books.publisher}</td>
			</tr>
		</c:forEach>

	</table>
	<form action = "/controller/Create_Book.do" method = "post">	<!-- ${contextPath} -->
		<input type = "button" name = "btn_create" value = "+">
	</form>
</body>
</html>