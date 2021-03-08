<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="deptpackage.Emp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Object o=request.getAttribute("k1");
Emp e=(Emp)request.getAttribute("details");

if( e ==null)
{
	e = new Emp(0,"","");
	
	
}

if( o == null)
{
		 o =" ";
	
}

List<Emp> users = (List)request.getAttribute("ms");
if(users == null)
{
	users =new ArrayList();
}

%>

<form action="lastservlet" method="post">

<Br/> Emp_No 
<input type="text" name="uno"  value ="<%= e.getEmpno()%>"/>
<Br/>Name
<input type="text" name="uname" value ="<%= e.getName()%>"/>
<Br/> Dept
<input type="text" name="dept" value ="<%= e.getDeptid()%>" />


<Br/><input type="submit" name="por" value="empgetdetails"/>
<input type="submit" name="por" value="empmultisel"/>
<input type="submit" name="por" value="empupdate"/>
<input type="submit" name="por" value="empinsert"/>

</form>

<%= o %>

<hr/>
<%
for(Emp u : users)
{
%>

<Br/><%= u.getEmpno()  %>  -- <%= u.getName() %> --
<%= u.getDeptid()  %>

<%
}
%>

</body>
</html>