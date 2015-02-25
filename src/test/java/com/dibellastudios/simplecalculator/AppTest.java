package com.dibellastudios.simplecalculator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

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
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
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
