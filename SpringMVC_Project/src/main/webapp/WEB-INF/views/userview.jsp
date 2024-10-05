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
${user.id} <br>
${user.age}<br>
${user.name}<br>
${user.gender}<br>
${user.frameworks}<br>
<c:if test="${user.number==1}">
sar ma loke chin bu.... i don't want to do my homework i am sad 
</c:if><br>
${user.country}

</body>
</html>