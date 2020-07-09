<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%@include file="adminHeader.jsp"%>
<body>
	<%
		String user = (String) session.getAttribute("adminUser");
	%>
	<div class="container">
		<h1>Admin Home</h1>
		<%
			if (user != null)
				out.print("<h2 style=color:#7179DF;> Welcome " + user + "</h2>");
			else
				response.sendRedirect("home.jsp");
		%>
	</div>
</body>
</html>