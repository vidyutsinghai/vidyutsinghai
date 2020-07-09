<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Softvin - Employee Registration</title>
</head>
<%@include file="adminHeader.jsp"%>

<body>
	<%
		String user = (String) session.getAttribute("adminUser");
	%>
	<div class="container">
		<div class="jumbotron">
			<h2>Employee Registration</h2>
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
			if (m != null) {
				if (m.equals("success")) {
					out.print("<h1 style= color:green;> Employee Registred Successfully</h1>");
				} else if (m.equals("existed")) {
					out.print("<h1 style= color:red;> Employee Mobile No. Already Existed</h1>");
				} else {
					out.print("<h1 style= color:red;> Employee Registion Failed</h1>");
				}
			}
		%>
		<hr>
		<form action="EmployeeRegistrationController" method="post">
			<div class="form-group">
				<label>Employee Name</label> <input type="text" class="form-control"
					id="exampleInputEmail1" placeholder="Enter Employee Name"
					name="ename" required>
			</div>

			<div class="form-group">
				<label>Employee Designation</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					placeholder="Enter Employee Designation" name="edesg" required>
			</div>
			<div class="form-group">
				<label>Employee Mobile No</label> <input type="number"
					class="form-control" id="exampleInputEmail1"
					placeholder="Enter Employee Mobile No" name="emobile" required>
			</div>

			<div class="form-group">
				<label>Employee Qualification</label> <select class="form-control"
					name="equalif">
					<option value="none">-- Nill --</option>
					<option value="12th">12th</option>
					<option value="Graduate">Graduate</option>
					<option value="Post Graduate">Post Graduate</option>
					<option value="PhD.">Doctorate</option>
					<option value="Professional">Professional</option>
					<option value="other">Others</option>
				</select>
			</div>
			<div class="form-group">
				<div class="form-check">
					<label>Gender</label> <br> <input class="form-check-input"
						type="radio" name="egender" id="exampleRadios1" value="male"
						checked> <label class="form-check-label"
						for="exampleRadios1">MALE</label> &nbsp;&nbsp;&nbsp;&nbsp; <input
						class="form-check-input" type="radio" name="egender"
						id="exampleRadios1" value="female" checked> <label
						class="form-check-label" for="exampleRadios1">FEMALE</label>
					&nbsp;&nbsp;&nbsp;&nbsp; <input class="form-check-input"
						type="radio" name="egender" id="exampleRadios1"
						value="transgender" checked> <label
						class="form-check-label" for="exampleRadios1">Transgender</label>
				</div>
			</div>

			<div class="form-group">
				<label>Employee Salary</label> <input type="number"
					class="form-control" id="exampleInputEmail1"
					placeholder="Enter Employee Salary" name="esalary" required>
			</div>

			<div class="form-group">
				<label>Employee Address</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					placeholder="Enter Employee Address" name="eaddr" required>
			</div>

			<button type="submit" class="btn btn-primary">Register</button>
			<button type="reset" class="btn btn-primary">Clear</button>
		</form>
		<br>
	</div>
</body>
</html>