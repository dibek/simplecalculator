package com.dibellastudios.simplecalculator;

import java.io.File;

import com.dibellastudios.simplecalculator.processor.FileProcessor;

/**
 * Hello world!
 *
 */
public class App
{
	
	
	
	public static String fileName;
	
    public static void main( String[] args )
    {
    	fileName = args[0];
    	System.out.println( "My File is " + fileName );
    	FileProcessor fileProcessor = new FileProcessor(fileName);
    	Number number = fileProcessor.processFileWithCoR();
        
        
        System.out.println( "My Result with CoR is " + number );
        
        number = fileProcessor.processFileWithRPN();
        
        System.out.println( "My Result with RPN is " + number );
        
    }
}
