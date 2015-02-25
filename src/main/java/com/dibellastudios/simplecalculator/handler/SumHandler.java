package com.dibellastudios.simplecalculator.handler;

public class SumHandler extends AbstractOperationHandler {

	public SumHandler(Operation operation) {
		super(operation);
	}

	@Override
	public void handleRequest(Operation operation) {
		Number addendum = operation.pollAddendum();
		if (addendum != null && addendum.doubleValue() > 0) {
			if (operation.getBase() != null && operation.getBase().doubleValue() > 0) {
				operation.setResult(addendum.doubleValue() + operation.getBase().doubleValue());
			}
			else {
				operation.setResult(addendum.doubleValue());
			}
		}
		System.out.println("Result sum =" + operation.getBase());
		nextStep(operation);
	}

}
