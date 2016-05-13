package com.nextech.dscrm.servlet;

//TODO Remove unused import statements
import java.beans.Statement;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/UserRequestServlet")
public class UserRequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// private ServletResponse response;

	public UserRequestServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO call getAllUserRequests() here
		//TODO Explain why you are setting content type of response here? 
		response.setContentType("text/html");
		// TODO Remove unused variables
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		//TODO Pass list received from getAllUserRequests() method to JSP from here
		RequestDispatcher dispatcher = context.getRequestDispatcher("/viewAllUserRequest.jsp");
		dispatcher.forward(request, response);
	}

	// TODO Change Return Type to List<UserRequest> in method getAllUserRequests
	public void getAllUserRequests() {
		//TODO Declare ArrayList<UserRequest> here
		try {
			// TODO Create a new object ArrayList<UserRequest> here
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/TEST", "root", "system");

			PreparedStatement pps = ((java.sql.Connection) conn).prepareStatement("SELECT * FROM dscrm.userrequest");
			ResultSet rs = pps.executeQuery();
			while (rs.next()) {
				// TODO Create a new object of UserRequest Here and set all the
				// fields from resultSet object
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("mobile"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getString("requirementDescription"));
			}
			// close connection
			conn.close();
		} catch (Exception ex) {
			// do something
		}
		//TODO Return ArrayList<UserRequest> object here
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
