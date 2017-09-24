package dbAccess;

// import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.io.IOException;

import javax.servlet.RequestDispatcher; // -----<<-------
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class makePayment
 */

import dbAccess.DBConnect;
import java.sql.*;

public class SpotInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
    /**     * @see HttpServlet#HttpServlet()     */
	
	private static DBConnect newConnection;
	
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			newConnection  = new DBConnect();					
		    newConnection.populateParkingList();
		    
	        request.setAttribute( "myAttribute", newConnection.parkingSpotList);	    	    		
		    RequestDispatcher rd = getServletContext().getRequestDispatcher( "/showSpots.jsp"  );
		    rd.forward( request, response );	
	} catch( SQLException e) {		
		e.printStackTrace();
	}catch( Exception e ) {
		e.printStackTrace();		
	}
	} // end of doPost
	
	
}
			
			 
