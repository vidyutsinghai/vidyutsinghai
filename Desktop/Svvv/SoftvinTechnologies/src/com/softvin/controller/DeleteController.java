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

@WebServlet("/DeleteController")
public class DeleteController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobile = request.getParameter("empMobile");
		AdminModel model = new AdminModel();
		int i = model.deleteEmployee(mobile);
		ArrayList<Employee> list = model.getAllEmployee();

		RequestDispatcher rd = null;
		if (i != 0) {
			rd = request.getRequestDispatcher("employeeDetails.jsp");
			request.setAttribute("msg", "Data Deleted Successfully");
			request.setAttribute("LIST", list);
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("employeeDetail.jsp");
			request.setAttribute("msg", "Data Not Deleted ");
			request.setAttribute("LIST", list);
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
