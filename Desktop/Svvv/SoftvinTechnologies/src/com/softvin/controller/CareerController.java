package com.softvin.controller;

import java.io.IOException;

import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.infoviaan.beans.Carrer;
import com.softvin.model.AdminModel;
//CarrerController
@WebServlet("/CareerController")
public class CareerController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		AdminModel model = new AdminModel();
		ArrayList<Carrer> list = model.allCandidates();
		
		RequestDispatcher rd = request.getRequestDispatcher("candidate.jsp");
		request.setAttribute("LIST", list);
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cName = request.getParameter("cName");
		String cEmail = request.getParameter("cEmail");
		String cResume = request.getParameter("cResume");
		Carrer cc = new Carrer(cName, cEmail, cResume);

		AdminModel model = new AdminModel();
		int i = model.submitResume(cc);
		RequestDispatcher rd = null;
		if (i != 0) {
			rd = request.getRequestDispatcher("career.jsp");
			request.setAttribute("msg", "success");
			rd.forward(request, response);
		} else {
			rd = request.getRequestDispatcher("career.jsp");
			request.setAttribute("msg", "fail");
			rd.forward(request, response);
		}
	}

}
