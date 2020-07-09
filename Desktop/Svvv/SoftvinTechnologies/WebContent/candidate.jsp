<%@page import="com.infoviaan.beans.Carrer"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Softvin - Candidats for Job</title>
</head>
<%@include file="adminHeader.jsp"%>
<body>
	<%
		ArrayList<Carrer> list = (ArrayList<Carrer>) request.getAttribute("LIST");
	%>
	
	<div class="container">
	<div class="jumbotron">
		<h2>Candidate Applied for Job</h2>
	</div>
		<table class="table" border="1">
			<thead class="table-dark">
				<td>Name</td>
				<td>Email</td>
				<td>Resume</td>
			</thead>
			<%
				for (Carrer cc : list) {
			%>
			<tr>
				<td><%=cc.getcName() %></td>
				<td><%=cc.getcEmail() %></td>
				<td><%=cc.getcResume()%></td>
			</tr>
			<%
				}
			%>
		</table>
	</div>

</body>
</html>