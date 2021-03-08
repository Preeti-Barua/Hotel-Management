<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>







<form action="lastservlet" method="post">

<Br/> username 
<input type="text" name="uname"  value ="<c:out value="${existingdetails.username}" />"/>
<Br/>password
<input type="text" name="pwd" value ="<c:out value="${existingdetails.password}" />"/>
<Br/> email
<input type="text" name="email" value ="<c:out value="${existingdetails.email}" />" />
<br/> pincode
<input type="text" name="pincode" value ="<c:out value="${existingdetails.pincode}" />"/>

<Br/><input type="submit" name="por" value="getdetails"/>
<input type="submit" name="por" value="update"/>
<input type="submit" name="por" value="insert"/>
<input type="submit" name="por" value="get users on pincode"/>

</form>
<c:out value="${k1}" />

<hr/>

<c:forEach var = "x" items = "${ms}">
<Br/>

<c:out value="${x.username}" />
--
<c:out value="${x.password}" />
--
<c:out value="${x.email}" />
--
<c:out value="${x.pincode}" />



</c:forEach>








</body>
</html>