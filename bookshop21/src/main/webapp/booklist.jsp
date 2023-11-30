<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Subjects</title>
</head>
<body>
	<jsp:useBean id="bl" class="com.sunbeam.beans.BooksBean"/>
	<jsp:setProperty property="subject" name="bl" param="subject"/>
	${bl.fetchBooks()}
	<form method="post" action="booklist.jsp">
		<c:forEach var="bookl" items="${bl.bookList}">
			<input type="checkbox" name="bookss" value="${bookl.id}"/> ${bookl.name} <br/>
		</c:forEach>
		<input type="submit" value="Add Cart"/>
		
	</form>
</body>
</html>

