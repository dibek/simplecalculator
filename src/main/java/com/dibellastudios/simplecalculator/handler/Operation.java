package com.dibellastudios.simplecalculator.handler;

import java.util.ArrayList;
import java.util.List;

public class Operation {

	Number base;
	List<Number> listAddendum;


	public Operation(Number addendum) {
		this.listAddendum = new ArrayList<Number>();
		listAddendum.add(addendum);
	}

	public void setResult(Number result) {
		this.base = result;
	}

	

	public Number getBase() {
		return this.base;
	}
	public Number getAddendum(){
		return this.listAddendum.get(listAddendum.size()-1);
	}
	
	public void  setAddendum(Number addendum){
		this.listAddendum.add(addendum);
	}

	@Override
	public String toString() {
		return "Operation [base=" + base + ", addendum=" + listAddendum + "]";
	}
	
	
}
