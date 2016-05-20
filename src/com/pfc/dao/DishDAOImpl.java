package com.pfc.dao;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.pfc.domain.Dish;
import com.pfc.domain.User;
import com.pfc.util.JDBCUtil;

public class DishDAOImpl extends baseDAO implements IDishDAO {

	@Override
	public ArrayList<Dish> findDishes(int pageNow,int pageSize) {
		// TODO Auto-generated method stub
		int minId=pageSize*(pageNow-1)+1;
		int maxId = pageSize*pageNow;
		String sql = "select * from dish order by dishid asc limit ?,?";
		Object parameters[] = {(minId-1),pageSize};
		ArrayList<Dish> arr = findObjs(sql, parameters, Dish.class);
		return arr;
	}
	
	@Override
	public Dish findDish(int dishId) {
		// TODO Auto-generated method stub
		String sql = "select * from dish where dishid = ? ";
		Object[] params={dishId};
		return (Dish)findObj(sql,params,Dish.class);
	}

	@Override
	public int insertDish(Dish dish) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateDish(Dish dish) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int deleteDish(int dishId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		String sql = "select count(*) from dish";
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		int count=0;
		try {
			conn = JDBCUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				count = rs.getInt(1);
			}
			JDBCUtil.free(rs, ps, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return count;
	}

}
