<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
${PhotoBean.getId()}
<img src="data:image/jpeg;base64,${PhotoBean.getBase64()}" alt="Image from database"/>
</body>
</html>