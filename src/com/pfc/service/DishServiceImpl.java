package com.pfc.service;

import java.util.ArrayList;

import com.pfc.dao.IDishDAO;
import com.pfc.domain.Dish;
import com.pfc.util.DaoFactory;

public class DishServiceImpl implements DishService{

	@Override
	public int getPageCount(int pageSize) {
		// TODO Auto-generated method stub
		IDishDAO dishDao = (IDishDAO)DaoFactory.newInstance("IDishDAO");
		int count = dishDao.getCount();
		int pageCount = (count - 1) / pageSize + 1;
		return pageCount;
	}
		
}
