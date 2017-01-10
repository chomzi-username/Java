package com.goralczyk.warehouse;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.goralczyk.warehouse.serviceImpl.AlgorithmHanoiTowerImpl;


public class App 
{
	private static final Logger logger = LogManager.getLogger(App.class);
	
    public static void main( String[] args )
    {
    	
    	BasicConfigurator.configure();
		logger.setLevel(Level.ALL);
		
		
		
		AlgorithmHanoiTowerImpl algo = new AlgorithmHanoiTowerImpl();
        //logger.info("Enter number of discs: ");
        int discs = 3;
        algo.doTower(discs, "A", "B", "C");
        
    }
}
