package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import integration.InventorySystem;
import util.Amount;

class PaymentTest {
	private CashRegister cashRegister;
	private Payment payment;
	private Total total;
	private Sale sale;
	private InventorySystem inventorySystem;

	@BeforeEach
	void setUp() throws Exception {
		cashRegister = new CashRegister();
		payment = new Payment(cashRegister);
		inventorySystem = new InventorySystem();
		sale = new Sale(inventorySystem);
		total = new Total(new Amount(100), new Amount(25), sale);
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void testMakePayment() {
		payment.makePayment(new Amount(100), total);
		cashRegister.getBalance().getAmount();
		assertEquals(cashRegister.getBalance().getAmount(), 100);
	}
	
	@Test
	void testCalculateChange() {
		payment.calculateChange(new Amount(200), total);
		assertEquals(75.0, payment.getChange().getChange().getAmount());
	}

}
