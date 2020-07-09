package com.softvin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoviaan.beans.Employee;
import com.softvin.model.AdminModel;

@WebServlet("/EmployeeRegistrationController")
public class EmployeeRegistrationController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("ename");
		String designation = request.getParameter("edesg");
		String mobile = request.getParameter("emobile");
		String qualification = request.getParameter("equalif");
		String gender = request.getParameter("egender");
		float salary = Float.parseFloat(request.getParameter("esalary"));
		String address = request.getParameter("eaddr");

		Employee em = new Employee(name, designation, mobile, qualification, gender, salary, address);

		AdminModel model = new AdminModel();
		Employee ee = model.searchEmployee(mobile);
		RequestDispatcher rd = null;
		
		if (ee == null) {
			int i = model.registerEmployee(em);
			if (i != 0) {
				rd = request.getRequestDispatcher("empRegistration.jsp");
				request.setAttribute("msg", "success");
				rd.forward(request, response);
			} else {
				rd = request.getRequestDispatcher("empRegistration.jsp");
				request.setAttribute("msg", "fail");
				rd.forward(request, response);
			}
		}else {
			rd = request.getRequestDispatcher("empRegistration.jsp");
			request.setAttribute("msg", "existed");
			rd.forward(request, response);
		}
		
	}

}
