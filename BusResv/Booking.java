package BusResv;

import java.util.Date;
import java.util.Scanner;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Booking{
	private String passengerName;
	private int busNo;
	private Date date;

	public String getPassengerName() {
		return passengerName;
	}


	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}


	public int getBusNo() {
		return busNo;
	}


	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	
	public Booking() {
	    Scanner scanner = new Scanner(System.in);

	    System.out.println("Enter your name : ");
	    passengerName = scanner.next();

	    System.out.println("Enter your bus no : ");
	    busNo = scanner.nextInt();

	    System.out.println("Enter date dd-MM-yyyy : ");
	    String dateInput = scanner.next();
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

	    try {
	        date = dateFormat.parse(dateInput);
	    } catch (ParseException e) {
	        e.printStackTrace();
	    }
	}

	
	public boolean ifAvailable() throws SQLException {
		
		BusDAO busdao = new BusDAO();
		BookingDAO bookingdao = new BookingDAO();
		int capacity = busdao.getCapacity(busNo);
		int booked = bookingdao.getBookedCount(busNo, date);

			
			return booked < capacity ? true:false;
	}



	
	
	
	
}