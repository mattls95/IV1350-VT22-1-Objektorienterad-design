package se.kth.salesystem.integration;

public class DatabaseNotRespondingException extends RuntimeException {

	public DatabaseNotRespondingException() {
		super("Inventory system is not responding");
	}
}
