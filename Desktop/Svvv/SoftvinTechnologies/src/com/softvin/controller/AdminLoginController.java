package com.softvin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softvin.model.AdminModel;

@WebServlet("/AdminLoginController")
public class AdminLoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uid = request.getParameter("adminUname");
		String pwd = request.getParameter("adminUpwd");
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(10000);
		
		session.setAttribute("adminUser", uid);

		AdminModel am = new AdminModel();
		int i = am.checkLogin(uid, pwd);
		if (i != 0) {
				response.sendRedirect("adminHome.jsp");				
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			request.setAttribute("msg", "Incorrect User Id Or Password");
			rd.forward(request, response);
			// response.sendRedirect("admin.jsp");
		}
	}

}
