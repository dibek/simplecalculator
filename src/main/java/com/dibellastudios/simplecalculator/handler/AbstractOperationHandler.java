package com.dibellastudios.simplecalculator.handler;

public abstract class AbstractOperationHandler implements OperationHandler {

	
	public volatile OperationHandler next = new NullHandler();
	public Operation operation;
	

	
	public AbstractOperationHandler(Operation operation) {
		
			this.operation = operation;
		
	}
	
	@Override
	public void setNext(OperationHandler nextHandler) {
		next = nextHandler;

	}

	@Override
	public Operation getOperation() {
		return this.operation;
	}
	public void nextStep(Operation operation){
		
		next.handleRequest(operation);
		//System.out.println(operation);
	}	

}
