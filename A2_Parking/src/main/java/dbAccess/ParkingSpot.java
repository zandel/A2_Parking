package dbAccess;


public class ParkingSpot {	
	
	
    private String streetName;
    private int spotNo;
    private String status;
 
    public String getstreetName() {
        return streetName;
    }
 
    public void setstreetName( String p_streetName ) {
        this.streetName = p_streetName;
    }
    
    
    public String getstatus() {
        return status;
    }
 
    public void setstatus( String p_status ) {
        this.status = p_status;
    }
    
    public int getspotNo() {
        return spotNo;
    }
 
    public void setspotNo( int p_spotNo ) {
        this.spotNo = p_spotNo;
    }         

} // end of class 

