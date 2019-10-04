package com.lti.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.dao.ProductDao;
import com.lti.exception.DataAccessException;
import com.lti.model.Product;

/**
 * Servlet implementation class DisplayTableData
 */
@WebServlet("/DisplayTableData")
public class DisplayTableData extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDao productDao = new ProductDao();
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		Integer cursor = (Integer) session.getAttribute("cursor");
		try {
			if(cursor == null)
				cursor=1;
			List<Product> list = productDao.fetch(cursor, cursor+4);
			request.setAttribute("list",list);
			session.setAttribute("cursor", cursor);
			request.getRequestDispatcher("productDetails.jsp").forward(request, response);
//			to print using toString()
//			for (Product product : list) {
//				out.println("<p>"+product+"</p>");
//			}
		} catch (DataAccessException e) {
			e.printStackTrace();
		}
	}
}
