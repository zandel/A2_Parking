package dbAccess;

import junit.framework.TestCase;

public class ComputeParkingFeeTest extends TestCase {

	public ComputeParkingFeeTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

	public void testCalculateFee() {
		ComputeParkingFee testFee = new ComputeParkingFee(300);
		double feeOutput = testFee.calculateFee();		
		assertEquals( 7.50, feeOutput);		
	}
}
