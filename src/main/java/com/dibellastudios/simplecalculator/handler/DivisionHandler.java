package com.dibellastudios.simplecalculator.handler;

public class DivisionHandler extends AbstractOperationHandler {

	/**
	 * Handler for the divide operation
	 * @param operation
	 */
	public DivisionHandler(Operation operation) {
		super(operation);
	}

	@Override
	public void handleRequest(Operation operation) {
		Number addendum = operation.pollAddendum();
		if (addendum != null && addendum.doubleValue() > 0) {
			if (operation.getBase() != null && operation.getBase().doubleValue() > 0) {
				operation.setResult(operation.getBase().doubleValue()/addendum.doubleValue() );
			}
			else {
				operation.setResult(addendum.doubleValue());
			}
		}
		System.out.println("Result division =" + operation.getBase());
		nextStep(operation);
	}

}
