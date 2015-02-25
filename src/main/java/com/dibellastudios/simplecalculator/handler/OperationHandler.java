package com.dibellastudios.simplecalculator.handler;

public interface OperationHandler {

	
	public void handleRequest(Operation operation);
	public void setNext(OperationHandler next);
	public Operation getOperation();
	
}
