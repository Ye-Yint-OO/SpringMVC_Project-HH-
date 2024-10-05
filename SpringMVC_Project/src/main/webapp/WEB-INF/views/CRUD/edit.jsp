<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="beanToEdit" action="edit" method="post">
	Title<form:input path="title" type="text" value="${book.getTitle()}"/> <br>
	Author<form:input path="author" type="text" value="${book.getAuthor()}"/> <br>
	Price<form:input path="price" value="${book.getPrice()}"/> <br>
	<input type="submit" value="Edit"><br>
	<input type="hidden" name="id" value="${book.getId()}">
	
</form:form>
</body>
</html>