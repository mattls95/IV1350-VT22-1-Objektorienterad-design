package model;

import java.time.LocalDateTime;

/**
 *  Represents a receipt.
 */
public class Receipt {
	private LocalDateTime dateAndTime;
	private Sale sale;
	private Payment payment;
	private Change change;
	
	 /**
     * Creates a new instance, representing a receipt.
     * @param dateAndTime The date and time of the sale
     * @param sale The information that will be on the receipt.
     * @param payment The information with the payment
     * @param change The change given out to the customer
     */
	public Receipt(LocalDateTime dateAndTime, Sale sale, Payment payment, Change change) {
		this.dateAndTime = dateAndTime;
		this.sale = sale;
		this.payment = payment;
		this.change = change;
	}
	
	/**
	 * Makes a receipt by calling its toString method
	 */
	public void makeReceipt() {
		this.toString();
	}

	/**
     * Turns the instance into a <code>String</code>.
     * @return The instance as a <code>String</code>.
     */
	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("----------Receipt------------\n");
		stringBuilder.append("Time of purchase: " + dateAndTime + "\n");
		stringBuilder.append("Purchased Items:\n" + sale.toString() + "\n");
		stringBuilder.append("Total price for sale: " + sale.getTotal().getTotalAmount() + "\n");
		stringBuilder.append("Total VAT for sale: " + sale.getTotal().getTotalVAT() + "\n");
		stringBuilder.append("Paid Amount: " + payment.getPayment() + "\n");
		stringBuilder.append("Change Received: " + payment.getChange() + "\n");
		stringBuilder.append(("----------End----------------"));
		return stringBuilder.toString();
	}
	
	

}
