package com.lti.controller;
import java.util.ArrayList;
import java.util.List;

import com.lti.model.Option;
import com.lti.model.Question;
import com.lti.model.Subject;

public class QuestionBankLoader {
	
	public static List<Question> loadQuestionsOnJava(){
		QuestionBank qb=new QuestionBank();
		
		Subject s=new Subject();
		s.setName("Java");
		qb.addNewSubject(s);
		//question1
		Question q=new Question();
		q.setQuestion("what is G1 in Java?");
		
		List<Option>ops=new ArrayList<Option>();	
		ops.add(new Option("G1 is a garbage collector",true));
		ops.add(new Option("G1 is another name for jeevan",false));
		ops.add(new Option("G1 is the name of a spy agency",false));
		ops.add(new Option("G1 is sequel of ra.one",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
		
		//question1
		q=new Question();
		q.setQuestion("What is the stored in the object obj in following lines of code?");
		
		ops=new ArrayList<Option>();	
		ops.add(new Option("Memory address of allocated memory of object",false));
		ops.add(new Option("NULL",true));
		ops.add(new Option("Any arbitrary pointer",false));
		ops.add(new Option("Garbage",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
		
		//question2
		q=new Question();
		q.setQuestion("Which of these statement is incorrect?");
		
		ops=new ArrayList<Option>();	
		ops.add(new Option("Every class must contain a main() method",true));
		ops.add(new Option("Applets do not require a main() method at all",false));
		ops.add(new Option("There can be only one main() method in a program",false));
		ops.add(new Option("main() method must be made public",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
		
		//question3
		q=new Question();
		q.setQuestion("Which of these is a mechanism for naming and visibility control of a class and its content?");
		
		ops=new ArrayList<Option>();	
		ops.add(new Option("Object",false));
		ops.add(new Option("Packages",true));
		ops.add(new Option("Interfaces",false));
		ops.add(new Option("None of the Mentioned.",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
		
		q=new Question();
		q.setQuestion("Which of these access specifiers can be used for a class so that its members can be accessed by a different class in the different package?");
		
		ops=new ArrayList<Option>();	
		ops.add(new Option("Public",true));
		ops.add(new Option("Protected",false));
		ops.add(new Option("Private",false));
		ops.add(new Option("No Modifier",false));
		q.setOptions(ops);
		qb.addNewQuestion(s, q);
		return qb.getQuestionsFor(s);
		
	}

}
