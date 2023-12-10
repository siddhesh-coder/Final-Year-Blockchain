package com.state_government;

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
 * Servlet implementation class state_government_request_status
 */
@WebServlet("/state_government_request_status")
public class state_government_request_status extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public state_government_request_status() {
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
		String emailid=Dbconn.Semail;
		String status = "Sending";
		try {
			Connection con;
			con = Dbconn.conn();

			Statement st = con.createStatement();
			st.executeUpdate("update user_request_funds set State_Gov_status='"+status+"',State_Gov_Email='"+emailid+"' where U_ID='"
					+ id + "'");

			System.out.println("OK ");
			pw.println("<script> alert('Funds Request Send Successfuly');</script>");
			RequestDispatcher rd = request
					.getRequestDispatcher("/State_Government_Home.jsp");
			rd.include(request, response);
		} catch (Exception exc) {

		}
	}

}
