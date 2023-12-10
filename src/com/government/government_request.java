package com.government;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.connection.Dbconn;

/**
 * Servlet implementation class government_request
 */
@WebServlet("/government_request")
public class government_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public government_request() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		PrintWriter pw = response.getWriter();
		String id = request.getParameter("txt_id");
		String emailid=Dbconn.Gemail;
		System.out.println("Email- ID=>"+emailid);
		String status = "Accept";
		try {
			Connection con;
			con = Dbconn.conn();

			Statement st = con.createStatement();
			st.executeUpdate("update user_request_funds set Government_status='"+status+"',Government_Eamil='"+emailid+"' where U_ID='"
					+ id + "'");

			System.out.println("OK ");
			pw.println("<script> alert('Funds Request Send Successfuly');</script>");
			RequestDispatcher rd = request
					.getRequestDispatcher("/Government_Home.jsp");
			rd.include(request, response);
		} catch (Exception exc) {

		}
	}

}
