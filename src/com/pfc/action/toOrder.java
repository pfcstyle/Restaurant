package com.pfc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pfc.dao.IDishDAO;
import com.pfc.dao.IOrderDAO;
import com.pfc.dao.IOrderItemDAO;
import com.pfc.domain.Dish;
import com.pfc.domain.Order;
import com.pfc.domain.User;
import com.pfc.service.MyCart;
import com.pfc.service.OrderItemService;
import com.pfc.service.OrderService;
import com.pfc.util.DaoFactory;

public class toOrder extends HttpServlet {

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
		ArrayList<Dish> dishes = mc.getAllDishes();
		request.setAttribute("orderDishes", dishes);
		
		User user = (User)request.getSession().getAttribute("loginUser");
		Order order = new Order();
		order.setuserid(user.getuserid());
		order.setorderprice(mc.getTotalPrice());
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyddHHss");//可以方便地修改日期格式
		String hehe = dateFormat.format( now );
		int orderId = Integer.parseInt(hehe);
		
		order.setorderid(orderId);
		order.setordercreatedate(now.toString());
		request.setAttribute("order", order);
		OrderItemService itemS = (OrderItemService)DaoFactory.newInstance("OrderItemService");
		IOrderDAO orderDao = (IOrderDAO)DaoFactory.newInstance("IOrderDAO");
		orderDao.insertOrder(order);
		itemS.insertOrderItems(dishes, orderId);
		mc.clearCart();
		request.getRequestDispatcher("showMyOrder.jsp").forward(request, response);
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
