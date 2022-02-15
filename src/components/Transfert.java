package components;

// 1.3.3 Creation of the Transfert class

public class Transfert extends Flow {

	private int issuingAccountNumber;

	public Transfert(double amount) {
		super(amount);
	}

	public int getIssuingAccountNumber() {
		return issuingAccountNumber;
	}

	public void setIssuingAccountNumber(int issuingAccountNumber) {
		this.issuingAccountNumber = issuingAccountNumber;
	}

}