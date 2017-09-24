package dbAccess;
import java.sql.SQLException;
import junit.framework.TestCase;

public class DBConnectTest extends TestCase {

	public DBConnectTest(String name) {
		super(name);
	}
	protected void setUp() throws Exception {
		super.setUp();
	}
	protected void tearDown() throws Exception {
		 super.tearDown();
	}
	public void testGetBalance() {
		
		DBConnect newConn;		
		try {
			newConn = new DBConnect();
			newConn.set1000( "777888" );
			double myBalance = newConn.getBalance ( "777888" );
			assertTrue( myBalance == 1000 );
		} catch ( ClassNotFoundException e ) {						
			fail(e.getMessage());
		} catch ( SQLException e ) {			
			fail( "SQLException caught! " + e.getMessage() ); //--<<-  indeed gets caught when DB down,
			                                                  //--<<-- see Failure trace			
		}
		
	}
}
