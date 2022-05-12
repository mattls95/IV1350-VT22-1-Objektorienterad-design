package se.kth.salesystem.util;

import java.util.Objects;

/**
 * Represents an identification of a customer.
 */
public class CustomerID {
	private Integer customerID;

	/**
	 * Creates an new instance, representing the specified customerID
	 * 
	 * @param customerID The ID number represented by the new created instance.
	 */
	public CustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	/**
	 * Get the value of customerID
	 * 
	 * @return The value of costumerID
	 */
	public Integer getCustomerID() {
		return customerID;
	}

	/**
	 * Checks if this instance is equal to another instance.
	 * 
	 * @param obj The other instance.
	 * @return <code>true</code> if all attributes are the same, the same class and
	 *         if it is not null. <code>false</code> otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CustomerID other = (CustomerID) obj;
		return Objects.equals(customerID, other.customerID);
	}

}
