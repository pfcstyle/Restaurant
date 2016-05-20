<%@page import="com.pfc.domain.Order"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page import = "com.pfc.domain.Dish" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
<title>购物车</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="./css/styles.css" type="text/css" />

</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0"
	text="#000000" link="#000000" vlink="#000000" alink="#000000">

<table width="100%" border="0" cellspacing="0" cellpadding="0"
	bgcolor="#FFFFFF" height="100%">
	<tr valign="top">
		<td>
		
		<table width="98%" border="0" cellspacing="2" cellpadding="0"
			align="center">
			<tr bgcolor=#808000>
				<td height="1" bgcolor="#999999"></td>
			</tr>
		</table>
		<table width="98%" border="0" cellspacing="2" cellpadding="0"
			align="center">
			<tr>
				<td height="5"></td>
			</tr>
		</table>
		<table width="98%" border="0" cellspacing="0" cellpadding="0"
			align="center">
			
			<tr>
				<td>
				<table width="100%" border="0" align="center" cellpadding="2"
					cellspacing="1" bgcolor="#c0c0c0">
					<tr bgcolor="#dadada">
						<td height="22" width="50">
						<div align="center"><font color="#000000">订单编号</font></div>
						</td>
						<td width="610" height="22">
						<div align="center"><font color="#000000">用户id</font></div>
						</td>
						<td height="22" width="104">
						<div align="center"><font color="#000000">创建时间</font></div>
						</td>
						<td height="22" width="100">
						<div align="center"><font color="#000000">总价</font></div>
						</td>
					</tr>

					<%
				    	Order order = (Order)request.getAttribute("order");
				    %>
					<tr bgcolor="#ffffff">
						<td width="50" align="center" height="22"><font
							color="#000000"><%=order.getorderid()%></font>
						</td>
						<td align="center" height="22"><font color="#000000"><%=order.getuserid()%></font>
							<input type="hidden" name="prodid" value="500047">
						</td>
						<td width="104" align="center" height="22"><font
							color="#000000"><%=order.getordercreatedate()%></font>
						</td>
						<td width="100" class="hh" align="center" height="22">￥<%=order.getorderprice()%></td>
					</tr>
				</table>
				</td>
			</tr>
			<tr><td><br/><br/><br/></td></tr>
			<tr>
				<td>
				<table width="100%" border="0" align="center" cellpadding="2"
					cellspacing="1" bgcolor="#c0c0c0">
					<tr bgcolor="#dadada">
						<td height="22" width="50">
						<div align="center"><font color="#000000">订单编号</font></div>
						</td>
						<td width="610" height="22">
						<div align="center"><font color="#000000">菜名</font></div>
						</td>
						<td height="22" width="104">
						<div align="center"><font color="#000000">数量</font></div>
						</td>
						<td height="22" width="100">
						<div align="center"><font color="#000000">单价</font></div>
						</td>
						<td width="116" height="22">
						<div align="center"><font color="#000000">总价</font></div>
						</td>
					</tr>
					
					<%
				    	ArrayList<Dish> dishes = (ArrayList<Dish>)request.getAttribute("orderDishes");
				    	for(int i=0;i<dishes.size();i++){
				    			Dish dish = dishes.get(i);
				    			%>
				    				<tr bgcolor="#ffffff">
										<td width="50" align="center" height="22"><font
											color="#000000"><%=order.getorderid() %></font></td>
										<td align="center" height="22"><font color="#000000"><%=dish.getdishname() %></font>
										<input type="hidden" name="prodid" value="500047"></td>
										<td width="104" align="center" height="22"><font
											color="#000000"><%=dish.getBuyNum() %></font></td>
										<td width="100" class="hh" align="center" height="22">￥<%=dish.getdishnowprice() %></td>
										<td width="116" class="bb" align="center" height="22"><font
											color="#000000">￥<%=dish.getBuyNum()*dish.getdishnowprice() %></font></td>
									</tr>
				    			<%
				    		}
				     %>
				     
					<tr bgcolor="#dadada">
						<td width="50" height="22" align="center"><font
							color="#000000">合计</font></td>
						<td height="22" align="center"><font color="#000000">-</font></td>
						<td width="104" height="22" align="center"><font
							color="#000000">-</font></td>
						<td width="100" class="hh" height="22" align="center"><font
							color="#000000">-</font></td>
						<td width="116" class="bb" align="center" height="22"><font
							color="#000000">￥<%=order.getorderprice() %> </font></td>
					</tr>
				</table>
				<br>
				<table width="300" border="0" cellspacing="1" cellpadding="4"
					align="center" bgcolor="#c0c0c0">
					<tr bgcolor="#dadada">
						<td height="10" align="center" style="cursor:hand" ><a href="/Restaurant/LoginCheck"><font
							color="#000000">继续购物</font></a></td>
						<td height="10" align="center" style="cursor:hand" ><font
							color="#000000">生成订单成功！！！！</font></td>
					</tr>
				</table>
				</td>
			</tr>
		</table>
		</td>
	</tr>
</table>
<br>
</body>
</html>

