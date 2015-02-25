package com.dibellastudios.simplecalculator.handler;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Operation {

	Number base;
	Queue<Number> listAddendum;


	public Operation(Number addendum) {
		this.listAddendum = new LinkedBlockingQueue<Number>();
		if (base == null){
			setResult(addendum);
		}
	}

	public void setResult(Number result) {
		this.base = result;
	}

	

	public Number getBase() {
		return this.base;
	}
	public Number pollAddendum(){
		return this.listAddendum.poll();
	}
	
	public void  addAddendum(Number addendum){
		this.listAddendum.add(addendum);
	}

	@Override
	public String toString() {
		return "Operation [base=" + base + ", addendum=" + listAddendum + "]";
	}

	public void setBase(Number base) {
		this.base = base;
		
	}
	
	
}
