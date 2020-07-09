<%@page import="com.infoviaan.beans.Employee"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Softvin - Employee Detail</title>

</head>
<%@include file="adminHeader.jsp"%>
<body>
	<%
		String user = (String) session.getAttribute("adminUser");
	%>
	<div class="container">
		<div class="jumbotron">
			<h1 style="color: green;">Employee Details</h1>
			<br>
			<%
			if(user!=null)
				out.print("<h2 style=color:#7179DF;> Welcome " + user + "</h2>");
			else
				response.sendRedirect("home.jsp");
			%>

		</div>
		<%
			String m = (String) request.getAttribute("msg");
			if (m != null)
				out.print("<h1 style=color:blue;>" + m + " </h1>");
		%>
	</div>
	<hr>
	<%
		ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("LIST"); //by deafult Object type
	%>
	<div class="container">
		<table class="table" border="1">
			<thead class="table-dark">
				<th>Name</th>
				<th>Designation</th>
				<th>Salary</th>
				<th>Mobile</th>
				<th>Qualification</th>
				<th>Gender</th>
				<th>Address</th>
				<th></th>
				<th></th>
			</thead>
			<%
				for (Employee ee : list) {
			%>
			<tr>
				<td><%=ee.getEname()%></td>
				<td><%=ee.getEdesignation()%></td>
				<td><%=ee.getEsalary()%></td>
				<td><%=ee.getEmobile()%></td>
				<td><%=ee.getEqualification()%></td>
				<td><%=ee.getEgender()%></td>
				<td><%=ee.getEaddress()%></td>
				<td><a href="DeleteController?empMobile=<%=ee.getEmobile()%>"
					class="btn btn-primary"
					onclick="return confirm('Are you really want to Delete this Record?')">Delete</a></td>
				<td><a href="UpdateController?empMobile=<%=ee.getEmobile()%>"
					class="btn btn-primary">Update</a></td>
			</tr>

			<%
				}
			%>
		</table>
	</div>

</body>
</html>