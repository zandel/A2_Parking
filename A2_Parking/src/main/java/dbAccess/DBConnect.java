package dbAccess;

import java.sql.*;
import java.util.ArrayList;

public class DBConnect {
	
private Connection myConn;

String myString;

ArrayList<ParkingSpot> parkingSpotList = new ArrayList<ParkingSpot>();
	
	public DBConnect() throws ClassNotFoundException, SQLException {
		
		myString = "abcdef"; // -----<< --- debug only --				
		
		String dbUrl = "jdbc:mysql://localhost/onlinejobseek";
		
		String user = "root";
		String password = "";
		
		Class.forName("com.mysql.jdbc.Driver");
		myConn = DriverManager.getConnection(dbUrl, user, password);
		System.out.println("initializing database...");
		Statement myStmt = myConn.createStatement(); 
	}
	
	public boolean searchUser(String username, String password) {
		PreparedStatement myStmt = null; 
		ResultSet myRS = null;
		
		// System.out.println("Now in searchUser...");		
		try {
			myStmt = myConn.prepareStatement("select * from student_login where student_name=? and student_Password=? ");
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			myRS = myStmt.executeQuery();
			
			if(myRS.next()) {
				return true;
			}
			else {
				return false;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return false;		
	} // end of searchUser
	
	public double getBalance( String regno ) throws SQLException {
		PreparedStatement myStmt = null; 
		ResultSet myRS = null;
		
				
		try {
			myStmt = myConn.prepareStatement("select balance from registration where registrationNumber=?");
			myStmt.setString(1, regno);
			
			myRS = myStmt.executeQuery();
			
			if(myRS.next()) {
				
				double theBalance = myRS.getDouble("balance") ;								
				return theBalance;
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
		System.out.println("Hm.......... returning -1?????");
		return -1;
				
	} // end of searchUser
	

	/**
	public String getMyString(  ) {
		return myString;
	}	
	**/
	
	public  void populateParkingList() {			   
		      
		        String driverName = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/onlinejobseek";
				String userName = "root";
				String password = "";
				
		      try 
				{			
					Class.forName(driverName);		
					Connection con = DriverManager.getConnection(url, userName, password);
					
					String sql = "select * from parking_spot";				
					
					PreparedStatement ps = con.prepareStatement(sql);
			        ResultSet rs = ps.executeQuery();
			        		        				
			        while(rs.next()) { 
			        	
			        	ParkingSpot psp = new ParkingSpot();	        	
						psp.setstreetName( rs.getString("street_name") );
						
						psp.setspotNo( rs.getInt("spot_No") );
						psp.setstatus(rs.getString("status"));
						//
						parkingSpotList.add(psp);
			        }		        
			        //}
				}
				catch(Exception ex)
				{
					;
				}	
		      
		}	
	
	public  void set1000( String regno) {			   
	      
		PreparedStatement myStmt = null; 
		ResultSet myRS = null;
		
		// System.out.println("Now in searchUser...");		
		try {
			myStmt = myConn.prepareStatement("update registration set balance = 1000 where registrationnumber=? ");
			myStmt.setString(1, regno);			
			myStmt.executeUpdate();						
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	} //end of 
	
	public  void deductFee( double parkFee, String regno) {			   
	      
		PreparedStatement myStmt = null; 
		ResultSet myRS = null;		
				
		try {
			myStmt = myConn.prepareStatement("update registration set balance = balance - ? where registrationnumber=? ");
			myStmt.setDouble (1, parkFee);
			myStmt.setString(2, regno);
			
			myStmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}  //end of 
	
	public  void doTopUp( int regNumber, double amount  ) {			   
	      
		PreparedStatement myStmt = null; 
		ResultSet myRS = null;		
				
		try {
			myStmt = myConn.prepareStatement("update registration set balance = balance + ? where registrationnumber=? ");
			
			myStmt.setDouble( 1, amount  );
			myStmt.setInt( 2,  regNumber );
			
			myStmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		
	}  //end of 
      
	public  void setSpotStatus( String newStatus, String streetName, int spotNumber  ) {			   
	      
		PreparedStatement myStmt = null; 
		ResultSet myRS = null;
		
		// System.out.println("Now in searchUser...");		
		try {
			myStmt = myConn.prepareStatement( "update parking_spot set status=? where STREET_NAME=? and spot_no=?" );
			myStmt.setString ( 1, newStatus );
			myStmt.setString ( 2, streetName );
			myStmt.setInt    ( 3, spotNumber );
			
			myStmt.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	} // end of	setSpotStatus	
	
	public  void insertParkingReg() {	// ------------- IGNORE for now ----------	   	      
        String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/onlinejobseek";
		String userName = "root";
		String password = "";		
      try 
		{			
			Class.forName(driverName);		
			Connection con = DriverManager.getConnection(url, userName, password);			
			String sql = "Insert into parkingReg (street, spotno, registration, starttime, duration, totalamt";						
			PreparedStatement ps = con.prepareStatement(sql);
	        ResultSet rs = ps.executeQuery();	        
	        /**		        				
	       
	        *****/        	        		}
		catch(Exception ex)
		{
			;
		}      
} // ----------------------------------- end of // ------------- IGNORE for now ----------	
	
	
	
}






