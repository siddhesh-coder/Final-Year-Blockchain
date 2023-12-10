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

import Blockchain.ptop;

import com.connection.Dbconn;
import com.mysql.jdbc.PreparedStatement;

/**
 * Servlet implementation class state_government_request
 */
@WebServlet("/state_government_request")
public class state_government_request extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public state_government_request() {
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
		HttpSession session = request.getSession(true);
		PrintWriter pw = response.getWriter();
		String id=request.getParameter("id");
		String txt_Pname = request.getParameter("txt_Pname");
		String txt_db_amount=request.getParameter("txt_db_amount");
		String txt_Pprice=request.getParameter("txt_Pprice");
		String accecpt_status=Dbconn.rolls;
		String emailid=Dbconn.Semail;
		try {
			Connection con;
			con = Dbconn.conn();

			String sql = "insert into tbl_tracker_info(Email_id,Name_info,Fund_amount,Transfer_amount,accecpt_status,R_ID) values(?,?,?,?,?,?)";
			PreparedStatement p = (PreparedStatement) con
					.prepareStatement(sql);
			p.setString(1,emailid );
			p.setString(2,txt_Pname );
			p.setString(3,txt_db_amount );
			p.setString(4,txt_Pprice);
			p.setString(5,accecpt_status);
			p.setString(6,id);
			 p.executeUpdate();
			String status = "Accept";
			Statement st = con.createStatement();
			st.executeUpdate("update user_request_funds set State_Gov_status='"+status+"' where State_Gov_Email='"+emailid+"' and U_ID='"
					+ id + "'");
			System.out.println("OK ");
			String data="State_Government"+"#"+txt_Pname+"#"+txt_db_amount+"#"+txt_Pprice+"#"+accecpt_status+"#"+emailid;
			ptop.ptopverify(4,data);
			pw.println("<script> alert('Funds Request Send Successfuly');</script>");
			RequestDispatcher rd = request
					.getRequestDispatcher("/State_Government_Home.jsp");
			rd.include(request, response);
		} catch (Exception exc) {

		}
	}

}
