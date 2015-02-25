package com.dibellastudios.simplecalculator.handler;

public class MultiplyHandler extends AbstractOperationHandler {

	public MultiplyHandler(Operation operation) {
		super(operation);
	}

	@Override
	public void handleRequest(Operation operation) {
		if (operation.getAddendum() != null && operation.getAddendum().doubleValue() > 0) {
			if (operation.getBase() != null && operation.getBase().doubleValue() > 0) {
				operation.setResult(operation.getAddendum().doubleValue() * operation.getBase().doubleValue());
			}
		}
		
		nextStep(operation);

	}

}
