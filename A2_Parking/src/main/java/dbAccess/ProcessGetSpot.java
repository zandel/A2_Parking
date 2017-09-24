package dbAccess;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class processGetSpot
 */
public class ProcessGetSpot extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProcessGetSpot() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("processGetSpot: Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// doGet(request, response);
		
		String theStreet = request.getParameter("street");
		String spotNo = request.getParameter("spotNo");
		String colourStatus = request.getParameter("colour");
		
		System.out.println("---------------------------");
		System.out.println(theStreet);
		System.out.println(spotNo);
		System.out.println(colourStatus);
		System.out.println("---------------------------");
		
		request.setAttribute( "myStreet", theStreet );
		request.setAttribute( "mySpot", spotNo );		
		
		
		if (  colourStatus.equalsIgnoreCase("FREE")   )
		{
			try {							
				RequestDispatcher rdx = getServletContext().getRequestDispatcher( "/handleSpotPayment.jsp"  );			
				rdx.forward( request, response );					
			}
			catch (Exception e) {
				System.out.println("-------oh no----xxxxxxxxxxxcption----------");
			}
		}
		else {
			;
			try {
				DBConnect newConnection = new DBConnect();	
				newConnection.setSpotStatus( "FREE", theStreet, Integer.parseInt( spotNo )  );
				
				RequestDispatcher rdx = getServletContext().getRequestDispatcher( "/startHere.jsp"  );			
				rdx.forward( request, response );					
			}
			catch (Exception e) {
				System.out.println("-------oh no----xxxxxxxxxxxcption----------");
			}
		}
	}

}
