package controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entities.Orders;
import model.OrdersModel;

/**
 * Servlet implementation class OrdersController
 */
@WebServlet("/Orders")
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action  = request.getParameter("action");
		if(action == null){
			doGetFindAll(request, response);
		}else{
			if(action.equalsIgnoreCase("edit")){
				doGetEdit(request, response);
			}else if(action.equalsIgnoreCase("delete")){
				doGetDelete(request, response);
			}else if(action.equalsIgnoreCase("add")){
				request.getRequestDispatcher("Orders/add.jsp").forward(request, response);
			}
		}
	}
	protected void doGetFindAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		OrdersModel ordersModel = new OrdersModel();
		List<Orders> orders = ordersModel.findAll();
		request.setAttribute("orders", orders);
		
		request.getRequestDispatcher("/Orders/index.jsp").forward(request, response);
	}
	protected void doGetEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersModel ordersModel = new OrdersModel();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			Orders order = ordersModel.find(id);
			if(order == null){
				throw new Exception();
			}else{
				request.setAttribute("order", order);
				request.getRequestDispatcher("Orders/edit.jsp").forward(request, response);
			}
		} catch (Exception e) {
			request.setAttribute("error", "Cant edit Orders");
			request.setAttribute("orders", ordersModel.findAll());
			request.getRequestDispatcher("Orders/index.jsp").forward(request, response);
		}
	}
	protected void doGetDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersModel ordersModel = new OrdersModel();
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			if(!ordersModel.delete(ordersModel.find(id))){
				throw new Exception();
			}
		} catch (Exception e) {
			request.setAttribute("error", "delete failed");
		}
		request.setAttribute("orders", ordersModel.findAll());
		request.getRequestDispatcher("Orders/index.jsp").forward(request, response);
	}
	
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equalsIgnoreCase("add")){
			doPostAdd(request, response);
		}else if(action.equalsIgnoreCase("edit")){
			doPostEdit(request, response);
		}else if(action.equalsIgnoreCase("search")){
			doPostSearch(request, response);
		}
	}
	
	protected void doPostAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			OrdersModel ordersModel = new OrdersModel();
			Orders orders = new Orders();
			orders.setName(request.getParameter("name"));
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = dateFormat.parse(request.getParameter("dateCreation"));
			orders.setDateCreation(newDate);
			orders.setPayment(request.getParameter("payment"));
			orders.setStatus(true);
			if(ordersModel.create(orders)){
				response.sendRedirect("Orders");
			} else{
				throw new Exception();
			}
		} catch (Exception e) {
			request.setAttribute("error", "Add Failed");
			request.getRequestDispatcher("/Orders/add.jsp").forward(request, response);
		}		
	}
	protected void doPostEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		OrdersModel ordersModel = new OrdersModel();
		try {		
			int id = Integer.parseInt(request.getParameter("id"));
			Orders orders = ordersModel.find(id);
			orders.setName(request.getParameter("name"));
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date newDate = dateFormat.parse(request.getParameter("dateCreation"));
			orders.setStatus(request.getParameter("status") != null);
			orders.setDateCreation(newDate);
			if(ordersModel.update(orders)){
				response.sendRedirect("Orders");
			}else{
				throw new Exception();
			}
		} catch (Exception e) {
			request.setAttribute("error", "Update Failed");
			int id = Integer.parseInt(request.getParameter("id"));
			request.setAttribute("order", ordersModel.find(id));
			request.getRequestDispatcher("Orders/edit.jsp").forward(request, response);
		}		
	}
	
	protected void doPostSearch(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String[] date = request.getParameter("dateCreation").split("-");
		int year = Integer.parseInt(date[0]);
		int month = Integer.parseInt(date[1]);
		int day = Integer.parseInt(date[2]);
		OrdersModel ordersModel = new OrdersModel();
		request.setAttribute("orders", ordersModel.search(year, month, day));
		request.getRequestDispatcher("Orders/index.jsp").forward(request, response);
	}
}
