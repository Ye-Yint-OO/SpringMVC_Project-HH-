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
${error}
<form:form modelAttribute="beanForLogin" action="login" method="post">
Email<form:input path="email"/> <br>
Password<form:input path="password" type="password"/><br>
<input type="submit" value="login"><br>
<a href="create">Create Account</a>

</form:form>
</body>
</html>