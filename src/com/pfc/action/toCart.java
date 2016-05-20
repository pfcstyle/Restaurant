package com.pfc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfc.dao.IDishDAO;
import com.pfc.domain.Dish;
import com.pfc.service.MyCart;
import com.pfc.util.DaoFactory;

public class toCart extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		MyCart mc =(MyCart)request.getSession().getAttribute("myCart");
		if(request.getParameter("type")==null){//直接查看购物车
			//获取购物车的所有数据
				ArrayList<Dish> dishes = mc.getAllDishes();
				request.setAttribute("cartDishes", dishes);
				request.setAttribute("totalPrice", mc.getTotalPrice());
				request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
			
			return;
		}
		String id = request.getParameter("id");
		IDishDAO dishDao = (IDishDAO)DaoFactory.newInstance("IDishDAO");
		String type = request.getParameter("type");
		if("add".equals(type)){
			Dish dish = (Dish)dishDao.findDish(Integer.parseInt(id));
			mc.addDish(id, dish);
			mc.setTotalPrice();
			//获取购物车的所有数据
			ArrayList<Dish> dishes = mc.getAllDishes();
			request.setAttribute("cartDishes", dishes);
			request.setAttribute("totalPrice", mc.getTotalPrice());
			//跳转到我的购物车
			request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
		}else if("del".equals(type)){
			mc.delDish(id);
			mc.setTotalPrice();
			ArrayList<Dish> dishes = mc.getAllDishes();
			request.setAttribute("cartDishes", dishes);
			request.setAttribute("totalPrice", mc.getTotalPrice());
			request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
		}else if("update".equals(type)){
			String[] DishNums=request.getParameterValues("dishNum");
			mc.updateDishNum(DishNums);
			mc.setTotalPrice();
			ArrayList<Dish> dishes = mc.getAllDishes();
			request.setAttribute("cartDishes", dishes);
			request.setAttribute("totalPrice", mc.getTotalPrice());
			request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
		}else if("clear".equals(type)){
			System.out.println("clear");
			mc.clearCart();
			mc.setTotalPrice();
			ArrayList<Dish> dishes = mc.getAllDishes();
			request.setAttribute("cartDishes", dishes);
			request.setAttribute("totalPrice", mc.getTotalPrice());
			request.getRequestDispatcher("showMyCart.jsp").forward(request, response);
		}
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
