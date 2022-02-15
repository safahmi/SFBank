package components;

import java.util.concurrent.atomic.AtomicInteger;

//1.2.1 Creation of the account class

public abstract class Account {

	// Attributes
	protected String label;
	protected double balance;
	protected int accountNumber;
	protected Client client;
	private static final AtomicInteger count = new AtomicInteger(0);

	// Constructor
	public Account(String label, Client client) {
		this.label = label;
		this.client = client;
		this.accountNumber = count.incrementAndGet();
	}

	// Accessors end Mutators of each attribute
	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(Flow flow) {
		throw new UnsupportedOperationException("Will be implement in release 1.3.5");
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * account number is automatically handle and this method seems to be dangerous
	 * 
	 * @param accountNumber
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	// toString() method
	@Override
	public String toString() {
		return "(Client : " + client + ", " + "Label : " + label + ", " + "Balance : " + balance + ", Account number : "
				+ accountNumber + ")";
	}

}
