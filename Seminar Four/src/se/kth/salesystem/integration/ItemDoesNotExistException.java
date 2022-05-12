package se.kth.salesystem.integration;

public class ItemDoesNotExistException extends Exception {
	private Integer itemNotFound;

	/**
	 * Creates a new instance with a message specifying for which item the search
	 * failed.
	 * 
	 * @param item The item that could not be found
	 */
	public ItemDoesNotExistException(Integer item) {
		super("Unable to find item with itemID " + item);
		itemNotFound = item;
	}

	/**
	 * @return The item that could not be found
	 */
	public Integer getItemNotFound() {
		return itemNotFound;
	}

}
