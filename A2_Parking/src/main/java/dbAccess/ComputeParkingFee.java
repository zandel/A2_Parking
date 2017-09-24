package dbAccess;

import java.util.Scanner;

public class ComputeParkingFee {

	double baseRate;
	static double totalAmount;	
	
	private int parkingTime = -1;
	
	public ComputeParkingFee( int time) {
		baseRate = 1.5;
		totalAmount = 0;
		
		parkingTime = time;
		
	}

	public double calculateFee(  ) {
		
		
		totalAmount = (parkingTime)/60 * baseRate;
		
		System.out.println("totalamt: "+totalAmount);
		
		return totalAmount;
	}

	public static void main(String[] args) {
	/********
		Scanner input = new Scanner(System.in);		
		System.out.println("How many minutes do you wish to park? ");
		int min = input.nextInt();
		
		
		System.out.println("Start time: "+ obj.startTime());
		System.out.println("End time: "+ obj.endTime(min));
		System.out.println(obj.timeToPark);
		System.out.println("Total Amount:$ "+obj1.calculateFee());
		*********/
		
	}

}

