package com.lti.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lti.controller.QuestionBankLoader;
import com.lti.model.Option;
import com.lti.model.Question;

/**
 * Servlet implementation class QuestionLoaderServlet
 */
@WebServlet("/QuestionLoaderServlet")
public class QuestionLoaderServlet extends HttpServlet {

	private List<Question> questions;
	private int noOfQuestions;

	@Override
	public void init() throws ServletException {
		questions = QuestionBankLoader.loadQuestionsOnJava();
		noOfQuestions = questions.size();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Integer questionNo = (Integer) session.getAttribute("qNo");
		if (questionNo==null) 
			questionNo = 0;	
		else
			questionNo++;
		session.setAttribute("qNo", questionNo);
		Question q = questions.get(questionNo);
		session.setAttribute("currentQuestion", q);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String btnLabel = "Continue";
		int btnValue = 0;
		if(questionNo==noOfQuestions-1){
			btnLabel = "Finish";
			btnValue = 1;
		}
		out.print("<form action='CalculateScoreServlet'>");
		out.print("<p>Question No: "+(questionNo+1)+"out of "+noOfQuestions+"</p>");
		out.print("<h3>" + q.getQuestion() + "</h3>");
		int optionNo = 0;
		for(Option o : q.getOptions()){
			out.print("<input type='radio' name='opt' value='"+(optionNo++)+"'/>"+ o.getOption()+"<br/>");
		}
		out.print("<button type='submit' name='completed' value='"+btnValue+"'>"+btnLabel+"</button> <nbsp><nbsp>");
		out.print("<button type='submit' name='completed' value='1'>End Test</button>");
		out.print("</form>");
	}
}
