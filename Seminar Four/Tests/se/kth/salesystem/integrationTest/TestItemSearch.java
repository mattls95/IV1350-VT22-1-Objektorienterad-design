package se.kth.salesystem.integrationTest;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.net.PasswordAuthentication;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.salesystem.integration.InventorySystem;
import se.kth.salesystem.integration.ItemDoesNotExistException;

class TestItemSearch {
	InventorySystem inventorySystem;

	@BeforeEach
	void setUp() throws Exception {
		inventorySystem = new InventorySystem();
	}

	@AfterEach
	void tearDown() throws Exception {
		inventorySystem = null;
	}

	@Test
	void testExceptionThrownWithWrongID() {
		assertThrows(ItemDoesNotExistException.class, () -> {
			inventorySystem.checkItemExists(10);
		});
	}
	
	@Test
	void testExceptionThrownWithNull() {
		assertThrows(NullPointerException.class, () -> {
			inventorySystem.checkItemExists(null);
		});
	}
	
	@Test
	void testNoExceptionThrown() {
		String expectedMessage = "pass";
		try {
			inventorySystem.checkItemExists(1);
		} catch (Exception exception) {
			expectedMessage = exception.getMessage();
		}
		assertTrue(expectedMessage.contains("pass"));
	}

}
