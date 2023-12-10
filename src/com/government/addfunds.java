package com.government;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class addfunds
 */
@WebServlet("/addfunds")
public class addfunds extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public addfunds() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		PrintWriter pw = response.getWriter();
		String txt_Plocation = request.getParameter("txt_Plocation");
		String txt_amount = request.getParameter("txt_amount");
		String txt_fdate = request.getParameter("txt_fdate");
		String Gemail=Dbconn.Gemail;

		try {
			Connection con;
			con = Dbconn.conn();

			String sql = "insert into government_funds(State_government_Email_id,Funds_amount,Funds_date,Government_Email_id) values(?,?,?,?)";

			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);

			p.setString(1, txt_Plocation);
			p.setString(2, txt_amount);
			p.setString(3, txt_fdate);
			p.setString(4, Gemail);
			

			int i = p.executeUpdate();
			if (i != 0) {
				System.out.println("OK ");
				pw.println("<script> alert('Funds Send Successfuly');</script>");
				RequestDispatcher rd = request
						.getRequestDispatcher("/Government_Funds.jsp");
				rd.include(request, response);
			} else {

				RequestDispatcher rd = request
						.getRequestDispatcher("/Government_Home.jsp");
				rd.include(request, response);
				// System.out.print(" Wrong ID and Password");

			}

		} catch (Exception exc) {

		}

	}

}
