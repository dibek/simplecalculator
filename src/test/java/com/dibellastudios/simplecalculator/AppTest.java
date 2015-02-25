package com.dibellastudios.simplecalculator;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.dibellastudios.simplecalculator.handler.MultiplyHandler;
import com.dibellastudios.simplecalculator.handler.Operation;
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
    public void testApp()
    {
    	Operation baseOperation = new Operation(5);
        OperationProcessor operationProcessor = new OperationProcessor();
        baseOperation.setAddendum(10);
        operationProcessor.addHandler(new MultiplyHandler(baseOperation));
        baseOperation.setAddendum(10);
        operationProcessor.addHandler(new SumHandler(baseOperation));
        operationProcessor.handleRequest();
        
    }
}
