package com.dibellastudios.simplecalculator.processor;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import com.dibellastudios.simplecalculator.RPNCalculator;
import com.dibellastudios.simplecalculator.handler.Operation;

/**
 * This class is using the new Java7 notation for loading a file
 * 
 * @author giuseppe
 *
 */
public class FileProcessor {

	String strPath;

	public FileProcessor(String strPath) {
		this.strPath = strPath;
	}

	/**
	 * Using the CoR pattern
	 * 
	 * @return
	 */
	public Number processFileWithCoR() {
		Number result = null;

		Path path = FileSystems.getDefault().getPath("", strPath);
		List<String> lines;
		try {
			lines = Files.readAllLines(path, Charset.defaultCharset());

			Operation operation = new Operation(0);
			OperationProcessor operationProcessor = new OperationProcessor();
			for (String myLine : lines) {

				if (myLine != null) {
					OperationUtil.extraxtOperationFromLineCoR(myLine,
							operation, operationProcessor);
				}

			}
			operationProcessor.handleRequest();

			result = operation.getBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;

	}

	/**
	 * Using the RPN Calculator
	 * 
	 * @return
	 */
	public Number processFileWithRPN() {
		Number result = null;

		Path path = FileSystems.getDefault().getPath("", strPath);
		List<String> lines;
		try {
			lines = Files.readAllLines(path, Charset.defaultCharset());

			List<Object> listOperations = new ArrayList<Object>();
			for (String myLine : lines) {

				if (myLine != null) {
					OperationUtil.extraxtOperationFromLineRPN(myLine,
							listOperations);
				}

			}
			RPNCalculator rpnCalculator = new RPNCalculator(listOperations);

			result = rpnCalculator.execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static void main(String[] args) {
		FileProcessor fileProcessor = new FileProcessor(
				"/home/giuseppe/Documents/Personal/workspace/simplecalculator/src/main/resources/myCalcFile.txt");
		System.out.println("Using the CoR calculator "
				+ fileProcessor.processFileWithCoR());
		System.out.println("Using the RPN calculator "
				+ fileProcessor.processFileWithRPN());

	}

}
