<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.error{
color:red;
}
</style>
<title>Insert title here</title>
</head>
<body>
<form:form modelAttribute="userObj" action="fileupload" method="post" enctype="multipart/form-data">
Id <form:input path="id"/> 
<form:errors path="id" cssClass="error"></form:errors><br>

Age <form:input path="age"/>
<form:errors path="age" cssClass="error"></form:errors><br>

Name <form:input path="name"/>
<form:errors path="name" cssClass="error"></form:errors><br>

Gender
Male<form:radiobutton path="gender" value="Male"/>
Female<form:radiobutton path="gender" value="Female"/><br>

Frameworks 
<form:checkboxes items="${frameworks}" path="frameworks" /><br>

Number
<form:radiobuttons path="number" items="${numlist}"/> <br>

Country
<form:select path="country" items="${list}" multiple="multiple"></form:select> <br>

<input type="file" name="file">

<input type="submit" value="add"><br>

</form:form>
</body>
</html>