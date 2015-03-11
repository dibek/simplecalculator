package com.dibellastudios.simplecalculator.processor;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dibellastudios.simplecalculator.handler.DivisionHandler;
import com.dibellastudios.simplecalculator.handler.MultiplyHandler;
import com.dibellastudios.simplecalculator.handler.Operation;
import com.dibellastudios.simplecalculator.handler.SubtractHandler;
import com.dibellastudios.simplecalculator.handler.SumHandler;

public class OperationUtil {

	public enum EnumOperation {
		ADD, DIVIDE, MULTIPLY, SUBTRACT, APPLY
	};

	/**
	 * This extraction is using the CoR engine for calculation
	 * 
	 * @param myLine
	 * @param operation
	 * @param operationProcessor
	 */
	public static void extraxtOperationFromLineCoR(String myLine,
			Operation operation, OperationProcessor operationProcessor) {
		for (EnumOperation enumOp : EnumOperation.values()) {
			if (myLine.contains(enumOp.toString().toLowerCase())) {

				switch (enumOp) {
				case ADD:
					operation
							.addAddendum(Double.valueOf(estractNumber(myLine)));
					operationProcessor.addHandler(new SumHandler(operation));
					break;
				case DIVIDE:
					operation
							.addAddendum(Double.valueOf(estractNumber(myLine)));
					operationProcessor
							.addHandler(new DivisionHandler(operation));
					break;
				case MULTIPLY:
					operation
							.addAddendum(Double.valueOf(estractNumber(myLine)));
					operationProcessor
							.addHandler(new MultiplyHandler(operation));
					break;
				case SUBTRACT:
					operation
							.addAddendum(Double.valueOf(estractNumber(myLine)));
					operationProcessor
							.addHandler(new SubtractHandler(operation));
					break;
				case APPLY:
					operation.setBase(Double.valueOf(estractNumber(myLine)));
					break;
				default:

				}
			}
		}
	}

	/**
	 * This extraction is using the CoR engine for calculation
	 * 
	 * @param myLine
	 * @param operation
	 * @param operationProcessor
	 */
	public static void extraxtOperationFromLineRPN(String myLine,
			List<Object> listOperations) {

		for (EnumOperation enumOp : EnumOperation.values()) {
			if (myLine.contains(enumOp.toString().toLowerCase())) {

				switch (enumOp) {
				case ADD:
				case DIVIDE:
				case MULTIPLY:
				case SUBTRACT:
					listOperations.add(Double.valueOf(estractNumber(myLine)));
					listOperations.add(enumOp.toString().toLowerCase());
					break;
				case APPLY:
					listOperations.add(0,Double.valueOf(estractNumber(myLine)));
					break;
				default:

				}
			}
		}
	}

	public static String estractNumber(String myStr) {
		String exNum = null;
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(myStr);
		if (m.find()) {
			exNum = m.group();
		}
		return exNum;
	}
}
