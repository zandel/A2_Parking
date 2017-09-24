package dbAccess;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** * Servlet implementation class parkingReg      */

public class TopUpAccount extends HttpServlet {
	
	private static final long serialVersionUID = 1L;       
    /**     * @see HttpServlet#HttpServlet()     */
    public TopUpAccount() {        super();           }
	/**	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)	 */    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Here are we in the TopUpAccount servlet");
		
		String regNumber = request.getParameter("registration");
		String topupAmount = request.getParameter("amount");
		
		//-------------------
		System.out.println( regNumber  );	
		System.out.println("---------------------------");
		System.out.println( topupAmount );						
		
		try {
			DBConnect newConnection = new DBConnect();
			double oldBalance = newConnection.getBalance( regNumber  );
		     newConnection.doTopUp(  Integer.parseInt( regNumber ),  Double.parseDouble( topupAmount)  );
		    
		     double newBalance = newConnection.getBalance( regNumber  );	     		     		     
		     
		     request.setAttribute( "registration", regNumber );		    		    
		     request.setAttribute( "newBalance", newBalance);
		     request.setAttribute( "oldBalance", oldBalance);
		     request.setAttribute( "topUpAmount", topupAmount );		
		     
		RequestDispatcher rdx = getServletContext().getRequestDispatcher( "/TopUpReceipt.jsp"  );
		//
		rdx.forward( request, response );		
	
	} catch( SQLException e) {
		e.printStackTrace();	
	}catch( Exception e ) {
		e.printStackTrace();		
	}		
	}    
}
