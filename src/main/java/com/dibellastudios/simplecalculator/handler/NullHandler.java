package com.dibellastudios.simplecalculator.handler;

/**
 * Special handler for end of the chain
 * @author giuseppe
 *
 */
public class NullHandler implements OperationHandler {

	@Override
	public void handleRequest(Operation operation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setNext(OperationHandler next) {
		// TODO Auto-generated method stub

	}

	@Override
	public Operation getOperation() {
		// TODO Auto-generated method stub
		return null;
	}

}
