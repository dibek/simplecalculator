package com.dibellastudios.simplecalculator.handler;

/**
 * Interface for the handler of the operations
 * @author giuseppe
 *
 */
public interface OperationHandler {

	
	public void handleRequest(Operation operation);
	public void setNext(OperationHandler next);
	public Operation getOperation();
	
}
