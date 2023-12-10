package com.activity;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();
		session.invalidate();

		out.println("<script type=\"text/javascript\">");
		out.println("alert('You are successfully logged out!');");
		out.println("</script>");
		request.getRequestDispatcher("Login.jsp").include(request, response);
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		PrintWriter pw = response.getWriter();
		System.out.println("Login Servlet");
		String username = request.getParameter("txt_Uname");
		String Password = request.getParameter("txt_Password");
		System.out.println("Name" + request.getParameter("txt_Uname"));
		System.out.println("Password" + request.getParameter("txt_Password"));
		String roll = request.getParameter("roll");
		Dbconn.rolls=roll;
		Connection con;
		try {
			con = Dbconn.conn();
			if (roll.equals("Government")) {
				
					Statement stRegister = con.createStatement();
					ResultSet rsLogin;
					rsLogin = stRegister
							.executeQuery("select * from government_registration where Uemail='"
									+ username
									+ "' and Upassword='"
									+ Password
									+ "'");
					if (rsLogin.next()) {
						session.setAttribute("Gname", rsLogin.getString(1));
						session.setAttribute("Gemail", username);
						Dbconn.Gemail=username;
						RequestDispatcher rd = request
								.getRequestDispatcher("/Government_Home.jsp");
						rd.include(request, response);

					} else {
						pw.println("<script> alert(' Wrong UserName and Password');</script>");
						RequestDispatcher rd = request
								.getRequestDispatcher("/LoginPage.jsp");
						rd.include(request, response);

					}
				
			} else if (roll.equals("User")) {
				
					Statement stRegister = con.createStatement();
					ResultSet rsLogin;
					rsLogin = stRegister
							.executeQuery("select * from userregistration where Uemail='"
									+ username
									+ "' and Upassword='"
									+ Password
									+ "'");
					if (rsLogin.next()) {
						session.setAttribute("Uname", rsLogin.getString(1));
						session.setAttribute("Uemail", username);
						Dbconn.Uemail=username;
						RequestDispatcher rd = request
								.getRequestDispatcher("/User_Home.jsp");
						rd.include(request, response);

					} else {
						pw.println("<script> alert(' Wrong UserName and Password');</script>");
						RequestDispatcher rd = request
								.getRequestDispatcher("/LoginPage.jsp");
						rd.include(request, response);

					}
				
			} else if (roll.equals("State_Government")) {
				
					Statement stRegister = con.createStatement();
					ResultSet rsLogin;
					rsLogin = stRegister
							.executeQuery("select * from state_government_registration where Uemail='"
								+ username
								+ "' and Upassword='"
								+ Password
								+ "'");
					if (rsLogin.next()) {
						session.setAttribute("Semail", username);
						Dbconn.Semail=username;
						session.setAttribute("roll", roll);
						RequestDispatcher rd = request
								.getRequestDispatcher("/State_Government_Home.jsp");
						rd.include(request, response);

					} else {
						pw.println("<script> alert(' Wrong UserName and Password');</script>");
						RequestDispatcher rd = request
								.getRequestDispatcher("/LoginPage.jsp");
						rd.include(request, response);

					}
				

			} else if (roll.equals("District")) {
					Statement stRegister = con.createStatement();
					ResultSet rsLogin;
					rsLogin = stRegister
							.executeQuery("select * from district_registration where Uemail='"
								+ username
								+ "' and Upassword='"
								+ Password
								+ "'");
					if (rsLogin.next()) {
						session.setAttribute("Dist_email", username);
						Dbconn.Dist_email=username;
						session.setAttribute("roll", roll);
						RequestDispatcher rd = request
								.getRequestDispatcher("/District_Home.jsp");
						rd.include(request, response);

					} else {
						pw.println("<script> alert(' Wrong UserName and Password');</script>");
						RequestDispatcher rd = request
								.getRequestDispatcher("/LoginPage.jsp");
						rd.include(request, response);

					}
			
			} else if (roll.equals("Department")) {

				Statement stRegister = con.createStatement();
				ResultSet rsLogin;
				rsLogin = stRegister
						.executeQuery("select * from department_registration where Uemail='"
								+ username
								+ "' and Upassword='"
								+ Password
								+ "'");
				if (rsLogin.next()) {
					session.setAttribute("Departmentemail", username);
					Dbconn.Departmentemail=username;
					session.setAttribute("roll", roll);
					RequestDispatcher rd = request
							.getRequestDispatcher("/Department_Home.jsp");
					rd.include(request, response);

				} else {
					pw.println("<script> alert(' Wrong UserName and Password');</script>");
					RequestDispatcher rd = request
							.getRequestDispatcher("/LoginPage.jsp");
					rd.include(request, response);

				}

			}

		} catch (Exception e) {

		}
	}
}
