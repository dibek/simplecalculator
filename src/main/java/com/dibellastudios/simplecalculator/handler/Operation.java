package com.dibellastudios.simplecalculator.handler;

public class Operation {

	Number base;
	Number addendum;


	public Operation(Number addendum) {
		this.addendum = addendum;
	}

	public void setResult(Number result) {
		this.base = result;
	}

	

	public Number getBase() {
		return this.base;
	}
	public Number getAddendum(){
		return this.addendum;
	}
	
	public void  setAddendum(Number addendum){
		this.addendum = addendum;
	}

	@Override
	public String toString() {
		return "Operation [base=" + base + ", addendum=" + addendum + "]";
	}
	
	
}
