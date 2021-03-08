<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="lastservlet" method="post">

<Br/> Emp_No 
<input type="text" name="uno"  value ="<c:out value="${details.empno}" />"/>
<Br/>Name
<input type="text" name="uname" value ="<c:out value="${details.name}" />"/>
<Br/> Dept
<input type="text" name="dept" value ="<c:out value="${details.deptid}" />" />


<Br/><input type="submit" name="por" value="empgetdetails"/>
<input type="submit" name="por" value="empmultisel"/>
<input type="submit" name="por" value="empupdate"/>
<input type="submit" name="por" value="empinsert"/>
<input type="submit" name="por" value="empremove"/>

</form>

<c:out value="${k1}" />

<hr/>

<c:forEach var = "x" items = "${ms}">
<Br/>

<c:out value="${x.empno}" />
--
<c:out value="${x.name}" />
--
<c:out value="${x.deptid}" />



</c:forEach>



</body>
</html>