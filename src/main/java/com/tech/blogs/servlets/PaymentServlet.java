package com.tech.blogs.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

/**
 * Servlet implementation class PaymentServlet
 */
@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public PaymentServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		int amount = Integer.parseInt(request.getParameter("amount"));
		String info = request.getParameter("info");
		System.out.println(info);

		try {
			RazorpayClient client = new RazorpayClient("rzp_test_djE6sP6oJJMaf6", "biucxdtqRSnn329NfMRyW1rh");
			JSONObject options = new JSONObject();
			options.put("amount", amount * 100); // Note: The amount should be in paise.
			options.put("currency", "INR");
			options.put("receipt", "txn_123456");
			options.put("payment_capture", 1);
			Order order = client.orders.create(options);
			System.out.println(order);
			String order1 = order.toString();
			
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			out.write(order1);

		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("You paid" + amount);

	}

}
