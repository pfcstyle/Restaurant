package com.pfc.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pfc.dao.IDishDAO;
import com.pfc.dao.IUserDAO;
import com.pfc.domain.Dish;
import com.pfc.domain.User;
import com.pfc.service.DishService;
import com.pfc.service.MyCart;
import com.pfc.service.UserService;
import com.pfc.util.DaoFactory;

public class LoginCheck extends HttpServlet {

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

		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		//用于判断是否成功登陆并创建购物车
		boolean b = true;
		if(session.getAttribute("loginUser")==null){
			String username = request.getParameter("loginName");
			String password = request.getParameter("loginPass");
			UserService userservice = (UserService) DaoFactory.newInstance("UserService");
			RequestDispatcher rd = null;
			if(!userservice.validateUser(username, password)){
				b=false;
			}else{
				IUserDAO userDao = (IUserDAO)DaoFactory.newInstance("IUserDAO");
				User loginUser = (User)userDao.findUser(username, password);
				System.out.println(loginUser.getuserid()+" "+loginUser.getusername()+" "+loginUser.getpassword());
				session.setAttribute("loginUser", loginUser);
				//创建购物车
				MyCart mc =new MyCart();
				session.setAttribute("myCart", mc);
			}
		}
		if(b){
			int pageSize = 6;
			int pageNow = 1;
			DishService dService = (DishService)DaoFactory.newInstance("DishService");
			//获取总页数
			int pageCount = dService.getPageCount(pageSize);
			//设置当前页
			if(request.getParameter("bPageNow")!=null){
				pageNow = Integer.parseInt(request.getParameter("bPageNow").toString());
				if(pageNow<=0)pageNow=1;
				else if(pageNow>pageCount)pageNow=pageCount;
			}
			IDishDAO dishDao = (IDishDAO)DaoFactory.newInstance("IDishDAO");
			ArrayList<Dish> dishes = dishDao.findDishes(pageNow, pageSize);
			request.setAttribute("dishes", dishes);
			request.setAttribute("bPageCount", pageCount);
			request.setAttribute("bPageNow", pageNow);
			//跳转到购物大厅
			request.getRequestDispatcher("show.jsp").forward(request, response);
		}else{
			response.sendRedirect("login.html");
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
