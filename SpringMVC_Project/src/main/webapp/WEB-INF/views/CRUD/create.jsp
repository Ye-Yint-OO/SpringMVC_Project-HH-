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
<form:form modelAttribute="userInfo" action="create" method="post">
	Name<form:input path="name" type="text" /> <br>
	Email<form:input path="email" type="text"/> <br>
	Password<form:input path="password" type="password"/> <br>
	Role <form:radiobutton path="role" value="user"/>User  <form:radiobutton path="role" value="admin"/>Admin<br>
	<input type="submit" value="create"><br>
	<a href="login">Login</a>
</form:form>
</body>
</html>