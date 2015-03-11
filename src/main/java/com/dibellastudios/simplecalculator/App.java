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
    	FileProcessor fileProcessor = new FileProcessor(fileName);
    	Number number = fileProcessor.processFileWithCoR();
        System.out.println( "My File is " + fileName );
        
        System.out.println( "My Result is " + number );
    }
}
