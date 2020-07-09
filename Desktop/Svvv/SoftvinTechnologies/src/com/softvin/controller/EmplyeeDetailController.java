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

@WebServlet("/EmplyeeDetailController")
public class EmplyeeDetailController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminModel model = new AdminModel();
		ArrayList<Employee> al = model.getAllEmployee();
		
		RequestDispatcher rd = request.getRequestDispatcher("employeeDetails.jsp");
		request.setAttribute("LIST", al);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
