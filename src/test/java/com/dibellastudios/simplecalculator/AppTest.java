package com.dibellastudios.simplecalculator;



import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.dibellastudios.simplecalculator.handler.DivisionHandler;
import com.dibellastudios.simplecalculator.handler.MultiplyHandler;
import com.dibellastudios.simplecalculator.handler.Operation;
import com.dibellastudios.simplecalculator.handler.SubtractHandler;
import com.dibellastudios.simplecalculator.handler.SumHandler;
import com.dibellastudios.simplecalculator.processor.OperationProcessor;
import com.dibellastudios.simplecalculator.processor.OperationUtil.EnumOperation;

/**
 * Unit test for simple App.
 */
public class AppTest 
   
{
  



    /**
     * Using the CoR calculator 
     */
    @Test
    public void MultiplySumSubDivCoR()
    {
    	Operation baseOperation = new Operation(3);
    	 baseOperation.addAddendum(10);
    	 baseOperation.addAddendum(5);
    	 baseOperation.addAddendum(2);
    	 baseOperation.addAddendum(2);
        OperationProcessor operationProcessor = new OperationProcessor();
       
        operationProcessor.addHandler(new MultiplyHandler(baseOperation));
       
        operationProcessor.addHandler(new SumHandler(baseOperation));
        operationProcessor.addHandler(new SubtractHandler(baseOperation));
        operationProcessor.addHandler(new DivisionHandler(baseOperation));
        operationProcessor.handleRequest();
        assertTrue("16,5 expected", baseOperation.getBase().doubleValue() == 16.5);
    }
    
    
    /**
     * Using the RPN Calculator
     */
    @Test
    public void MultiplySumSubDivRPN() {
    	Object[] arrayOperations = {3,10,EnumOperation.MULTIPLY,5,EnumOperation.ADD,2,EnumOperation.SUBTRACT,2,EnumOperation.DIVIDE};
    	List<Object> listOperations = Arrays.asList(arrayOperations);
    	RPNCalculator rpnCalculator =  new RPNCalculator(listOperations);
    	assertTrue("16,5 expected",rpnCalculator.execute().doubleValue() == 16.5);
    }
    
    /**
     * Using the CoR calculator 
     */
    @Test
    public void MultiplyDivCoR()
    {
    	Operation baseOperation = new Operation(3);
    	 baseOperation.addAddendum(10);
    	 baseOperation.addAddendum(5);
    	
        OperationProcessor operationProcessor = new OperationProcessor();
       
        operationProcessor.addHandler(new MultiplyHandler(baseOperation));
       
       
        operationProcessor.addHandler(new DivisionHandler(baseOperation));
        operationProcessor.handleRequest();
        assertTrue("6 expected", baseOperation.getBase().intValue() == 6);
        
    }
    
    /**
     * Using the RPN Calculator
     */
    @Test
    public void MultiplyDivRPN() {
    	Object[] arrayOperations = {3,10,EnumOperation.MULTIPLY,5,EnumOperation.DIVIDE};
    	List<Object> listOperations = Arrays.asList(arrayOperations);
    	RPNCalculator rpnCalculator =  new RPNCalculator(listOperations);
    	 assertTrue("6 expected", rpnCalculator.execute().intValue() == 6);
    }
}
