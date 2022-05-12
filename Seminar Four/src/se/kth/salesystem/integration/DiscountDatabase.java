package se.kth.salesystem.integration;

import java.util.ArrayList;

import se.kth.salesystem.model.Sale;
import se.kth.salesystem.util.CustomerID;

/**
 * Represents the discount database.
 */
public class DiscountDatabase {
	private ArrayList<CustomerID> customerIDs = new ArrayList<>();

	/**
     *  Creates a new instance of the discount database if the code is commented out a 
     *  discount will be given and if not no discount will be given
     */
	public DiscountDatabase() {
		//addCustomerID();
	}

    /**
     * Checks if the customer has a discount.
     * @param customerID The identification of the customer.
     * @param sale The sale which contains the number of items 
     * @return boolean If the value is true a discount is given if it is false no discount is given
     */
	public boolean checkDiscount(Sale sale, CustomerID customerID) {
		boolean discountCustomerID = checkDiscountForCustomerID(customerID);
		boolean discountNumberOfItems = checkDiscountForNumberOfItemsInSale(sale);
		boolean discountFlag = false;
		if ((discountCustomerID || discountNumberOfItems) == true) {
			applyDiscount(sale);
			discountFlag = true;
		}

		return discountFlag;
	}

	 /**
     * Applies discount to the sale
     * @param sale The sale that discount will be added to
     */
	private void applyDiscount(Sale sale) {
		sale.applyDiscount();
	}

	 /**
     * Checks if a customer is eligible for a discount or not
     * @return boolean Returns true if a discount is given and false if not
     */
	private boolean checkDiscountForCustomerID(CustomerID customerID) {
		for (CustomerID customerIDToCheckAgainst : customerIDs) {
			if (customerID.equals(customerIDToCheckAgainst))
				return true;
		}
		return false;
	}

	/**
     * Checks if a customer has enough items to be eligible for a discount 
     * @return boolean Returns true if a discount is given and false if not
     */
	private boolean checkDiscountForNumberOfItemsInSale(Sale sale) {
		ArrayList<Item> items = new ArrayList<>();
		items = sale.getItems();
		if (items.size() > 10)
			return true;
		return false;
	}
	
	/**
     * Adds a customerID to the database which is eligible for a discount
     */
	private void addCustomerID() {
		customerIDs.add(new CustomerID(1));
	}

}
