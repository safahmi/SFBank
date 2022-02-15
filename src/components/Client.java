package components;

import java.util.concurrent.atomic.AtomicInteger;

//1.1.1 Creation of the client class

public class Client {

	// Attributes
	private String name;
	private String firstName;
	private int clientNumber;
	private static final AtomicInteger count = new AtomicInteger(0);

	// Constructor
	public Client(String name, String firstName) {
		this.name = name;
		this.firstName = firstName;
		this.clientNumber = count.incrementAndGet();
	}

	// Accessors end Mutators of each attribute
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getClientNumber() {
		return clientNumber;
	}

	/**
	 * client number is automatically handle and this method seems to be dangerous
	 * 
	 * @param clientNumber
	 */
	public void setClientNumber(int clientNumber) {
		this.clientNumber = clientNumber;
	}

	@Override
	public String toString() {
		return "(" + this.name + ", " + this.firstName + ", " + this.clientNumber + ")";
	}

}
