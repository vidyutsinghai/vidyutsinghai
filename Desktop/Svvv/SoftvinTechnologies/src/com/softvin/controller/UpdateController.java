package com.softvin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoviaan.beans.Employee;
import com.softvin.model.AdminModel;

@WebServlet("/UpdateController")
public class UpdateController extends HttpServlet {
	AdminModel model = new AdminModel();	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobile = request.getParameter("empMobile");
		Employee ee = model.searchEmployee(mobile);

		RequestDispatcher rd = request.getRequestDispatcher("udateEmployee.jsp");
		request.setAttribute("EMP", ee);
		rd.forward(request, response);
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

		int i = model.updateEmployee(em);
		ArrayList<Employee> list = model.getAllEmployee();

		RequestDispatcher rd = request.getRequestDispatcher("employeeDetails.jsp");
		request.setAttribute("msg", "Data Updated Successfully");
		request.setAttribute("LIST", list);
		rd.forward(request, response);
	}
}
