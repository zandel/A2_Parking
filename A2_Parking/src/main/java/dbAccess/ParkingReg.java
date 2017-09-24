package dbAccess;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/** * Servlet implementation class parkingReg      */

public class ParkingReg extends HttpServlet {
	
	private static final long serialVersionUID = 1L;       
    /**     * @see HttpServlet#HttpServlet()     */
    public ParkingReg() {        super();           }
	/**	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)	 */    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Here are we in the parkingReg servlet");
		String theStreet = request.getParameter("street");
		String spotNo = request.getParameter("spotNo");
		String registration = request.getParameter("registration");		
		//-------------------
		System.out.println( registration );	
		System.out.println("---------------------------");
		System.out.println( theStreet );
		System.out.println( spotNo );				
		
		String theDuration = request.getParameter("duration");
		System.out.println(theDuration);		
		
		ComputeParkingFee yourFee = new ComputeParkingFee( Integer.parseInt( theDuration) );
		
		double currentFee = yourFee.calculateFee() ;
		
		// System.out.println("fee:"+   currentFee   );		
		/* to do: 		 * if funds sufficient
		 * insert into database.table(registrationNumber,starttime, duration, totalamt)
		 * below: invoke parkingReceipt servlet		*/		
		
		try {
			DBConnect newConnection = new DBConnect();						
			
		    // the next line is just so we don't worry about balance when testing the payment:
		    newConnection.set1000( registration );
		    
		    //now deduct the fee:
		     newConnection.deductFee( currentFee, registration  );
		    
		     double newBalance = newConnection.getBalance(registration  );
		     
		     ParkingTimes timeHandy = new ParkingTimes();
		     String sTime = timeHandy.startTime()   ;
		     String eTime = ParkingTimes.endTime(  Integer.parseInt( theDuration) );
		     
		     System.out.println("Start time: "+ sTime);
		     System.out.println("End time: "+ eTime);
		     
		     //System.out.println("Start time: "+ timeHandy.startTime());
		     //System.out.println("End Time: " + ParkingTimes.endTime(  Integer.parseInt( theDuration) ));
		     
		     request.setAttribute( "streetName", theStreet );
		     request.setAttribute( "spotNumber",  spotNo );
		     request.setAttribute( "regNumber", registration );
		     //------------------------------
		     request.setAttribute( "startTime", sTime);
		     request.setAttribute( "endTime", eTime);
		     request.setAttribute( "duration", theDuration);
		     request.setAttribute( "newBalance", newBalance);
		     
		     System.out.println("Now invoking setBusySpot " + theStreet +  spotNo   );
		     newConnection.setSpotStatus( "BUSY", theStreet, Integer.parseInt( spotNo )  );
		     
		RequestDispatcher rdx = getServletContext().getRequestDispatcher( "/ParkingReceipt.jsp"  );
		//
		rdx.forward( request, response );		
	
	} catch( SQLException e) {
		e.printStackTrace();	
	}catch( Exception e ) {
		e.printStackTrace();	
		//System.out.println("-----------xxxxoh no xxxxxxxcption----------------");
	}
		
	/**
		try {				
			
			}
			catch (Exception e) {
				
			}
			**/				
	}    
}
