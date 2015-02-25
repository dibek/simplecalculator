package com.dibellastudios.simplecalculator;



import org.junit.Test;

import com.dibellastudios.simplecalculator.handler.DivisionHandler;
import com.dibellastudios.simplecalculator.handler.MultiplyHandler;
import com.dibellastudios.simplecalculator.handler.Operation;
import com.dibellastudios.simplecalculator.handler.SubtractHandler;
import com.dibellastudios.simplecalculator.handler.SumHandler;
import com.dibellastudios.simplecalculator.processor.OperationProcessor;

/**
 * Unit test for simple App.
 */
public class AppTest 
   
{
  



    /**
     * Rigourous Test :-)
     */
    @Test
    public void MultiplySumSubDiv()
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
        
    }
    
    /**
     * Rigourous Test :-)
     */
    @Test
    public void MultiplyDiv()
    {
    	Operation baseOperation = new Operation(3);
    	 baseOperation.addAddendum(10);
    	 baseOperation.addAddendum(5);
    	
        OperationProcessor operationProcessor = new OperationProcessor();
       
        operationProcessor.addHandler(new MultiplyHandler(baseOperation));
       
       
        operationProcessor.addHandler(new DivisionHandler(baseOperation));
        operationProcessor.handleRequest();
        
    }
}
