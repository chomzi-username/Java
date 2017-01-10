package com.goralczyk.warehouse.daoImpl;

import java.util.Stack;

import org.apache.log4j.*;
import com.goralczyk.warehouse.dao.CarPartsDao;
import com.goralczyk.warehouse.model.CarParts;

public class CarPartsDaoImpl implements CarPartsDao {
	
	private static Logger logger = LogManager.getLogger(CarPartsDaoImpl.class);
	
	private Stack<CarParts> stack;
	
	public CarPartsDaoImpl() {
		new Stack<CarParts>();
	}

	public CarParts create(CarParts carParts) {
		
		try{
			stack.push(carParts);
		}catch(NullPointerException e){
			logger.error("Problem with creating package of Car parts! ");
		}
		
		return carParts;
	}
}
