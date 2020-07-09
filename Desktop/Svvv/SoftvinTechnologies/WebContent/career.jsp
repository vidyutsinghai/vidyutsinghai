<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Softvin- Career</title>
</head>
<%@include file="header.jsp"%>
<body>
	<%
		String m = (String) request.getAttribute("msg");
	%>
	<div class="container">
		<div class="jumbotron">
			<h3>
				Softvin Career<br>
				<%
					if (m != null) {
						if (m.equals("success"))
							out.print("<h2 style=color:green;>Your Detail Submitted, We Will Reach You Soon</h2>");
						else if (m.equals("fail"))
							out.print("<h2 style=color:red;>Your Details Not Submited. Try Again</h2>");
						else
							out.print("<h2 style=color:blue;>Something went Wrong</h2>");
					}
				%>
				<br>Please Fill The Details for Employment :
			</h3>
			<br>
			<hr>
			<form action="CareerController" method="post">
				<div class="form-group">
					<label for="exampleInputPassword1">Name</label> <input type="text"
						class="form-control" id="exampleInputPassword1"
						placeholder="Enter Full Name" name="cName" required>
				</div>

				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label> <input
						type="email" class="form-control" name="cEmail"
						id="exampleInputEmail1" aria-describedby="emailHelp"
						placeholder="Enter email" required>
				</div>
				<div class="form-group">
					<label for="exampleFormControlFile1">Upload Your Resume</label> <input
						type="file" class="form-control-file" id="exampleFormControlFile1"
						name="cResume">
				</div>
				<br>
				<button type="submit" class="btn btn-primary">Submit</button>
			</form>
		</div>
	</div>
</body>
</html>