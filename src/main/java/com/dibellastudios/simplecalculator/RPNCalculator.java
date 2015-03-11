package com.dibellastudios.simplecalculator;

import java.util.LinkedList;
import java.util.List;

public class RPNCalculator {

	
	
	private List<Object> listOperations;
	
	public RPNCalculator(List<Object> listOperations) {
		this.listOperations = listOperations;
	}
	
	public Number execute() {
		
		 LinkedList<Double> linkedList = new LinkedList<Double>();
		    
		  List<Object> rpnValues = listOperations;
		   for (Object obj : rpnValues) {
			   if (obj.toString().toLowerCase().equals("add")) {
				   double result = linkedList.pollFirst() + linkedList.pollFirst();
				   linkedList.addFirst(result);
			   }
			   else if (obj.toString().toLowerCase().equals("multiply")) {
				   double result = linkedList.pollFirst() * linkedList.pollFirst();
				   linkedList.addFirst(result);
			   }
			   else if (obj.toString().toLowerCase().equals("divide")) {
				   double result = linkedList.pollFirst() / linkedList.pollFirst();
				   linkedList.addFirst(result);
			   }
			   else if (obj.toString().toLowerCase().equals("subtract")) {
				   double result = linkedList.pollFirst() - linkedList.pollFirst();
				   linkedList.addFirst(result);
			   }
			   else {
				   linkedList.add(Double.valueOf(obj.toString()));
			   }
		   }
		   System.out.println(linkedList);
		   return linkedList.getFirst();
	}
}
