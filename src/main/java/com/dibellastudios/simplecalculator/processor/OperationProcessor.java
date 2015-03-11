package com.dibellastudios.simplecalculator.processor;

import com.dibellastudios.simplecalculator.handler.OperationHandler;

public class OperationProcessor {

	OperationHandler baseHandler;
	OperationHandler lastHandler;

	public OperationProcessor() {
	}

	public void addHandler(OperationHandler opHandler) {
		if (this.baseHandler == null) {
			this.baseHandler = opHandler;
		} else {
			this.lastHandler.setNext(opHandler);
		}
		this.lastHandler = opHandler;
	}

	public void handleRequest() {
		if (baseHandler != null) {
			baseHandler.handleRequest(baseHandler.getOperation());
		}
	}

}
