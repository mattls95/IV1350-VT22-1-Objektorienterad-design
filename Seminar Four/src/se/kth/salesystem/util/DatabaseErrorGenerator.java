package se.kth.salesystem.util;

import se.kth.salesystem.integration.DatabaseNotRespondingException;

/**
 * Simulates an database error
 */
public class DatabaseErrorGenerator {

	/**
	 * Generates a database failure exception
	 */
	public static void generateDatabaseException() {
		throw new DatabaseNotRespondingException();
	}
}
