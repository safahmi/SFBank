package components;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicInteger;

// 1.3.2 Creation of the Flow class

public abstract class Flow {

	// Attributes
	private String comment;
	private int identifier;
	private double amount;
	private int targetAccountNumber;
	private boolean effect;
	private LocalDateTime date;
	private static final AtomicInteger count = new AtomicInteger(0);

	/**
	 * @param amount
	 * @param targetAccountNumber
	 */
	public Flow(double amount, int targetAccountNumber) {
		this.amount = amount;
		this.targetAccountNumber = targetAccountNumber;
		// For the date of flows, operations are carried out 2 days after the creation
		// of flows.
		// Use the new features of java 8 to add 2 days to the current date.
		this.date = LocalDateTime.now().plusDays(2);
		this.identifier = count.incrementAndGet();

	}

	// Accessors and Mutators
	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getIdentifier() {
		return identifier;
	}

	public void setIdentifier(int identifier) {
		this.identifier = identifier;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public int getTargetAccountNumber() {
		return targetAccountNumber;
	}

	public void setTargetAccountNumber(int targetAccountNumber) {
		this.targetAccountNumber = targetAccountNumber;
	}

	public boolean isEffect() {
		return effect;
	}

	public void setEffect(boolean effect) {
		this.effect = effect;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

}
