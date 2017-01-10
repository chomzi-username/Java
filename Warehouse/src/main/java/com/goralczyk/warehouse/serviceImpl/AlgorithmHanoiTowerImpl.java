package com.goralczyk.warehouse.serviceImpl;

import org.apache.log4j.*;

public class AlgorithmHanoiTowerImpl {

	private static Logger logger = LogManager.getLogger(AlgorithmHanoiTowerImpl.class);

	int countMoving = 0;

	public void doTower(int n, String start, String auxiliary, String end) {
		if (n == 1) {
			logger.info(start + " -> " + end);
			countMoving++;
		} else {
			doTower(n - 1, start, end, auxiliary);
			countMoving++;
			logger.info(start + " -> " + end);
			
			doTower(n - 1, auxiliary, start, end);
			countMoving++;
		}

		
	}
	
}
