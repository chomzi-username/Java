package com.goralczyk.warehouse.daoImpl;

import com.goralczyk.warehouse.dao.BoxDao;

public class BoxDaoImpl implements BoxDao{

	public BoxDao create(int width, int length, int height) {
		return create(1,1,1);
	}

}
