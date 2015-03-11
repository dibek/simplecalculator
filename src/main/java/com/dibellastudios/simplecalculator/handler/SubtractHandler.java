package com.dibellastudios.simplecalculator.handler;

public class SubtractHandler extends AbstractOperationHandler {

	public SubtractHandler(Operation operation) {
		super(operation);
	
	}

	@Override
	public void handleRequest(Operation operation) {
		Number addendum = operation.pollAddendum();
		if (addendum != null && addendum.doubleValue() > 0) {
			if (operation.getBase() != null && operation.getBase().doubleValue() > 0) {
				operation.setResult( operation.getBase().doubleValue() - addendum.doubleValue());
			}
			else {
				operation.setResult(addendum.doubleValue());
			}
		}
		System.out.println("Result subtract =" + operation.getBase());
		nextStep(operation);

	}

}
