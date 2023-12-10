package com.user;

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
 * Servlet implementation class funds_request
 */
@WebServlet("/funds_request")
public class funds_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public funds_request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession(true);
		PrintWriter pw = response.getWriter();
		String txt_fundsname = request.getParameter("txt_fundsname");
		String txt_amount = request.getParameter("txt_amount");
	
		String Gemail=Dbconn.Uemail;
String status="Pendding";
		try {
			Connection con;
			con = Dbconn.conn();

			String sql = "insert into user_request_funds(Funds_Name,Funds_amount,User_Email_id,Department_status,District_status,State_Gov_status,Government_status,Department_Email,District_Email,State_Gov_Email,Government_Eamil) values(?,?,?,?,?,?,?,?,?,?,?)";

			PreparedStatement p = (PreparedStatement) con.prepareStatement(sql);

			p.setString(1, txt_fundsname);
			p.setString(2, txt_amount);
			p.setString(3, Gemail);
			p.setString(4, status);
			p.setString(5, status);
			p.setString(6, status);
			p.setString(7, status);
			p.setString(8, status);
			p.setString(9, status);
			p.setString(10, status);
			p.setString(11, status);

			int i = p.executeUpdate();
			if (i != 0) {
				System.out.println("OK ");
				pw.println("<script> alert('Funds Request Send Successfuly');</script>");
				RequestDispatcher rd = request
						.getRequestDispatcher("/User_Request_Funds.jsp");
				rd.include(request, response);
			} else {

				RequestDispatcher rd = request
						.getRequestDispatcher("/User_Home.jsp");
				rd.include(request, response);
				// System.out.print(" Wrong ID and Password");

			}

		} catch (Exception exc) {

		}
	}

}
