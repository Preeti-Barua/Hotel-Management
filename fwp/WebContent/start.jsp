
<!DOCTYPE html>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="archcode.CUser"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
Object o = request.getAttribute("k1");// first time o is null
CUser o1 = (CUser)request.getAttribute("existingdetails");
if( o1 ==null)
{
	o1 = new CUser("","","",0);
	
	
}

if( o == null)
{
		 o =" ";
	
}

List<CUser> users = (List)request.getAttribute("ms");
if(users == null)
{
	users =new ArrayList();
}




%>

<form action="lastservlet" method="post">

<Br/> username 
<input type="text" name="uname"  value ="<%= o1.getUsername()%>"/>
<Br/>password
<input type="text" name="pwd" value ="<%= o1.getPassword()%>"/>
<Br/> email
<input type="text" name="email" value ="<%= o1.getEmail()%>" />
<br/> pincode
<input type="text" name="pincode" value ="<%= o1.getPincode()%>"/>

<Br/><input type="submit" name="por" value="getdetails"/>
<input type="submit" name="por" value="update"/>
<input type="submit" name="por" value="insert"/>
<input type="submit" name="por" value="get users on pincode"/>

</form>
<%= o %>

<hr/>
<%
for(CUser u : users)
{
%>

<Br/><%= u.getUsername()  %>  -- <%= u.getPassword() %> --
<%= u.getEmail()  %>  -- <%= u.getPincode() %>

<%
}
%>







</body>
</html>