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
<form:form action="viewphoto" method="post" modelAttribute="Photo" enctype="multipart/form-data">
<form:input path="file" type="file" name="img"/>
<input type="submit">
</form:form>
</body>
</html>