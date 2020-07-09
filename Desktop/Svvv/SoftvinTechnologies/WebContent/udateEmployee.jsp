<%@page import="com.infoviaan.beans.Employee"%>
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
<%Employee emp = (Employee)request.getAttribute("EMP");%>

	<div class="container">
		<div class="jumbotron">
			<h2>Update Employee Details</h2>
		</div>
		
		<hr>
		<form action="UpdateController" method="post">
			<div class="form-group">
				<label>Employee Name</label> <input type="text" class="form-control"
					id="exampleInputEmail1" placeholder="Enter Employee Name"
					name="ename" value="<%=emp.getEname()%>" required>
			</div>

			<div class="form-group">
				<label>Employee Designation</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					placeholder="Enter Employee Designation" name="edesg" value="<%=emp.getEdesignation() %>" required>
			</div>
			<div class="form-group">
				<label>Employee Mobile No</label> <input type="number"
					class="form-control" id="exampleInputEmail1"
					placeholder="Enter Employee Mobile No" name="emobile" value="<%=emp.getEmobile() %>" readonly="readonly">
			</div>

			<div class="form-group">
				<label>Employee Qualification</label> <select class="form-control"
					 value="<%=emp.getEqualification() %>" name="equalif">
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
					placeholder="Enter Employee Salary" value="<%=emp.getEsalary() %>" name="esalary" required>
			</div>

			<div class="form-group">
				<label>Employee Address</label> <input type="text"
					class="form-control" id="exampleInputEmail1"
					placeholder="Enter Employee Address" value="<%=emp.getEaddress() %>" name="eaddr" required>
			</div>

			<button type="submit" class="btn btn-primary">UPDATE</button>
			<button type="reset" class="btn btn-primary">Clear</button>
		</form>
		<br>
	</div>
</body>
</html>