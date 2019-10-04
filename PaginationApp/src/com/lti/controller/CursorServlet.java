package com.lti.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CursorServlet
 */
@WebServlet("/CursorServlet")
public class CursorServlet extends HttpServlet {

	private int pageSize=5;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer cursor = (Integer) session.getAttribute("cursor");
		int value = Integer.parseInt(request.getParameter("pointer"));

		if(value==-1){
			if(cursor==1)
				cursor=1;
			else
			cursor=cursor-pageSize;
		}
		else if(value==1)
			cursor=cursor+pageSize;

		session.setAttribute("cursor", cursor);
		response.sendRedirect("DisplayTableData");
	}

}
