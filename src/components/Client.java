package components;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

//1.1.1 Creation of the client class

public class Client {
	
	public static void main(String[] args) {
			Client client1 = new Client("Fahmi", "Samir");
			Client client2 = new Client("Loulou", "poulou");
			System.out.println(client1);
			System.out.println(client2);
				
			
		}
	
		
	//Attributes 
	private String name;
	private String firstName;
	private int clientNumber;
	private static final AtomicInteger count = new AtomicInteger(0);
	
	//Constructor 
	public Client(String value1, String value2) {
		this.name = value1;
		this.firstName = value2;
		this.clientNumber = count.incrementAndGet();
	}
	
	//Accessors end Mutators of each attribute
	private String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	private String getFirstName() {
		return firstName;
	}
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	private int getClientNumber() {
		return clientNumber;
	}
	private void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}
	
	// toString() method
	@Override
	public String toString() {	  
		return "(Lastname : " + name + ", "+ "Firstname : " + firstName + ", " + "Client number : " + clientNumber + ")";
	}  
	

}
