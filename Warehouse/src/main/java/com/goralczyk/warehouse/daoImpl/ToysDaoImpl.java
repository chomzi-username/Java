package com.goralczyk.warehouse.daoImpl;

import java.util.Stack;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.goralczyk.warehouse.dao.ToysDao;
import com.goralczyk.warehouse.model.Toys;

public class ToysDaoImpl implements ToysDao {
	
	private Stack<Toys> stack;
	
	private static Logger logger = LogManager.getLogger(ToysDaoImpl.class);

	public ToysDaoImpl() {
		new Stack<Toys>();
	}

	public Toys create(Toys toys) {
		try{
			stack.push(toys);
		}catch(NullPointerException e){
			logger.error("Problem with creating package of toys!");
		}
		
		return toys;
	}

}
