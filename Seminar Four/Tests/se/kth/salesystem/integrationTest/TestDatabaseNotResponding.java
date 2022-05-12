package se.kth.salesystem.integrationTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.salesystem.integration.DatabaseNotRespondingException;
import se.kth.salesystem.integration.ItemDoesNotExistException;
import se.kth.salesystem.util.DatabaseErrorGenerator;

class TestDatabaseNotResponding {

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testExceptionThrown() {
		assertThrows(DatabaseNotRespondingException.class, () -> {
			DatabaseErrorGenerator.generateDatabaseException();
		});
	}

}
