package com.dibellastudios.simplecalculator.handler;

public class MultiplyHandler extends AbstractOperationHandler {

	public MultiplyHandler(Operation operation) {
		super(operation);
	}

	@Override
	public void handleRequest(Operation operation) {
		Number addendum = operation.pollAddendum();
		if (addendum != null && addendum.doubleValue() > 0) {
			if (operation.getBase() != null && operation.getBase().doubleValue() > 0) {
				Number base =  operation.getBase();
				operation.setResult(addendum.doubleValue() * base.doubleValue());
			}
			else {
				operation.setResult(addendum.doubleValue());
			}
		}
		System.out.println("Result multipy =" + operation.getBase());
		nextStep(operation);

	}

}
