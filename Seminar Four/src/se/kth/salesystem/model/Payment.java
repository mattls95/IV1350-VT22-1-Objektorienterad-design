package se.kth.salesystem.model;

import se.kth.salesystem.util.Amount;

/**
 * Represents a payment of a specific sale.
 */
public class Payment {
	private Change change;
	private Amount payment;
	private CashRegister cashRegister;

	/**
	 * Creates a new instance, represented as a payment.
	 * 
	 * @param cashRegister The cash register that the payment should be entered into
	 */
	public Payment(CashRegister cashRegister) {
		this.cashRegister = cashRegister;
		this.change = new Change();
	}

	/**
	 * Get the value of change
	 * 
	 * @return The value of change
	 */
	public Change getChange() {
		return change;
	}

	/**
	 * Get the value of payment
	 * 
	 * @return The value of payment
	 */
	public Amount getPayment() {
		return payment;
	}

	/**
	 * Makes a payment
	 * 
	 * @param amount The amount that the payment consists of
	 * @param total  The total amount of the sale
	 */
	public void makePayment(Amount amount, Total total) {
		payment = amount;
		cashRegister.increaseBalance(amount);
		calculateChange(amount, total);
	}

	/**
	 * Calculates and updates the change amount
	 * 
	 * @param amount The amount that the payment consists of
	 * @param total  The total amount of the sale
	 */
	public void calculateChange(Amount amount, Total total) {
		this.change.calculateChange(amount, total);
	}

}
