<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%
   String name = request.getParameter( "username" );
   session.setAttribute( "theName", name );
%>
<%
   String password = request.getParameter( "password" );
   session.setAttribute( "theName", name );
%>
<html>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
<A HREF="NextPage.jsp">Continue</A>
</body>
</html>