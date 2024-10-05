<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<th>Id</th>
	<th>Title</th>
	<th>Author</th>
	<th>Price</th>
</tr>
<c:forEach var="book" items="${bookList}">
<tr>
	<td>${book.getId()}</td>
	<td>${book.getTitle()}</td>
	<td>${book.getAuthor()}</td>
	<td>${book.getPrice()}</td>
	<td><a href="showbooById?id=${book.getId()}">Edit</a></td>
	<td><a>Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>