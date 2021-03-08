<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="obj1" class="reflectionbasics.Circle"></jsp:useBean>
<h1> see what happens</h1>

<jsp:setProperty property="radius" name="obj1" value="4"/>

<jsp:getProperty property="radius" name="obj1" />



</body>
</html>