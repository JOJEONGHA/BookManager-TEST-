<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<table width="1000" align="center">
		<td>
			<form action="/bookmanager/controller/List.do" method="post"
				name="doList">
				<select name='sType' style="width: 15%;">
					<option value="Binfo">도서 설명</option>
					<option value="Bpub">출 판 사</option>
					<option value="Bnum" selected="selected">도서번호</option>
					<option value="Bauth">저 자</option>
					<option value="Bname">책 제목</option>
				</select> <input type="text" name="search" size="20" style="width: 70%;">
				<input type="submit" value="search" size="20" style="width: 13%;">
			</form>
		</td>
	</table>
	<table width="1000" align="center" border="1">
		<tr align="center" bgcolor="lightgreen">
			<td width="15%" height = "30px"><b>도서번호</b></td>
			<td width="50%"><b>책 제목</b></td>
			<td width="15%"><b>저 자</b></td>
			<td width="10%"><b>출 판 사</b></td>
		</tr>
		<!-- Print Book List -->
		<c:forEach var="books" items="${booksList}">
			<tr align="center">
				<td height = "40px">${books.booknum}</td>
				<td>${books.title}</td>
				<td>${books.authorname}</td>
				<td>${books.publisher}</td>
				<td>
					<form action="/bookmanager/controller/update.do">
						<input type="hidden" value="${books.booknum}" name="bookinfo">
						<input type="hidden" value="view" name="btnInfo"> <input
							type="submit" value="View!">
					</form>
				</td>
			</tr>
		</c:forEach>
		<td  align="center" colspan = "5">
			<form action="/bookmanager/controller/Create_Book.do" method="post">
				<input type="hidden" name="btn_create" value="first_visit">
				<input type="submit" value="+" style="width: 5%; height: 50px">
			</form>
		</td>

	</table>
</body>
</html>