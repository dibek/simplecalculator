package com.dibellastudios.simplecalculator;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.math.NumberUtils;

/**
 * This simple Calculator class uses a Reverse Polish Notation 
 * It is using a stack and retrieve the number and related operations.
 * The element remaining in the stack  is the result of the operations.
 * The operation permitted in this case are add/multiply/divide/subtract
 * @author giuseppe
 *
 */
public class RPNCalculator {

	
	
	private List<Object> listOperations;
	
	public RPNCalculator(List<Object> listOperations) {
		this.listOperations = listOperations;
	}
	
	public Number execute() throws Exception {
		
		 LinkedList<Double> linkedList = new LinkedList<Double>();
		    
		  List<Object> rpnValues = listOperations;
		   for (Object obj : rpnValues) {
			   if (obj.toString().toLowerCase().equals("add")) {
				   double result = linkedList.pollFirst() + linkedList.pollFirst();
				   System.out.println("Result sum " + result);
				   linkedList.addFirst(result);
			   }
			   else if (obj.toString().toLowerCase().equals("multiply")) {
				   double result = linkedList.pollFirst() * linkedList.pollFirst();
				   System.out.println("Result multiply " + result);
				   linkedList.addFirst(result);
			   }
			   else if (obj.toString().toLowerCase().equals("divide")) {
				   double result = linkedList.pollFirst() / linkedList.pollFirst();
				   System.out.println("Result divide " + result);
				   linkedList.addFirst(result);
			   }
			   else if (obj.toString().toLowerCase().equals("subtract")) {
				   double result = linkedList.pollFirst() - linkedList.pollFirst();
				   System.out.println("Result subtract " + result);
				   linkedList.addFirst(result);
			   }
			   else if (NumberUtils.isNumber(obj.toString())){
				   linkedList.add(Double.valueOf(obj.toString()));
			   }
			   else {
				   throw new Exception("Command not valid");
			   }
		   }
		   //System.out.println(linkedList);
		   return linkedList.getFirst();
	}
}
