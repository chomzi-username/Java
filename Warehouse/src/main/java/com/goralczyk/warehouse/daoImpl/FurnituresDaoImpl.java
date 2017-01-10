package com.goralczyk.warehouse.daoImpl;

import java.util.Stack;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.goralczyk.warehouse.dao.FurnituresDao;
import com.goralczyk.warehouse.model.Furnitures;

public class FurnituresDaoImpl implements FurnituresDao {
	
	private static Logger logger = LogManager.getLogger(Furnitures.class);
	
	private Stack<Furnitures> stack;
	
	public FurnituresDaoImpl(){
		new Stack<Furnitures>();
	}

	public Furnitures create(Furnitures furnitures) {
		try{
			stack.push(furnitures);
		}catch(NullPointerException e){
			logger.error("Proble with creating package of furnitures!");
		}
		return furnitures;
	}
	
}
