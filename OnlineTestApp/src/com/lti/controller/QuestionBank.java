package com.lti.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.lti.model.Question;
import com.lti.model.Subject;

public class QuestionBank {

	private Map<Subject, List<Question>> questionBank; // TODO private Map<Subject, Set<Question>>

	public QuestionBank() {
		questionBank=new HashMap<>();
	}

	public void addNewSubject(Subject subject) {
		questionBank.put(subject, new ArrayList<>());
	}
	
	public void addNewQuestion(Subject subject,Question question) {
		List<Question>questions=questionBank.get(subject);
		questions.add(question);
	}

	public List<Question>getQuestionsFor(Subject subject){
		return questionBank.get(subject);
	}


}
