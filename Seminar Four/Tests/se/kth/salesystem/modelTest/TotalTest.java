package se.kth.salesystem.modelTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import se.kth.salesystem.integration.InventorySystem;
import se.kth.salesystem.integration.Item;
import se.kth.salesystem.integration.ItemDTO;
import se.kth.salesystem.model.Sale;
import se.kth.salesystem.model.Total;
import se.kth.salesystem.model.VAT;
import se.kth.salesystem.util.Amount;
import se.kth.salesystem.util.Quantity;

class TotalTest {
	private static Total total;
	private static Sale sale;
	private static InventorySystem inventorySystem;

	@BeforeEach
	private void setUpBeforeClass() throws Exception {
		inventorySystem = new InventorySystem();
		sale = new Sale(inventorySystem);
		addItems();
		total = new Total(new Amount(100), new Amount(25),sale);
	}

	@AfterAll
	private static void tearDownAfterClass() throws Exception {
		total = null;
	}

	@Test
	public void testGetTotalAmount() {
		Amount actualAmount = total.getTotalAmount();
		Amount expectedAmount = new Amount(100);
		assertEquals(actualAmount.getAmount(), expectedAmount.getAmount(), "Equal");
	}
	
	@Test
	public void testGetTotalVAT() {
		Amount actualAmount = total.getTotalVAT();
		Amount expectedAmount = new Amount(25);
		assertEquals(actualAmount.getAmount(), expectedAmount.getAmount(), "Equal");
	}
	
	@Test
	public void testCalculateTotalAmount() {
		Amount actualAmount = total.calculateTotalAmount();
		Amount expectedAmount = new Amount(500);
		System.out.println(actualAmount.getAmount());
		System.out.println(expectedAmount.getAmount());
		assertEquals(actualAmount.getAmount(),expectedAmount.getAmount(), "Equal");
	}
	
	@Test
	public void testCalculateTotalVAT() {
		Amount actualAmount = total.calculateTotalVAT();
		Amount expectedAmount = new Amount(49);
		assertEquals(actualAmount.getAmount(),expectedAmount.getAmount(), "Equal");
	}
	
	@Test
	public void testGetTotalIncludingVAT() {
		Amount actualAmount = total.getTotalIncludingVAT();
		Amount expectedAmount = new Amount(125);
		assertEquals(expectedAmount.getAmount(), actualAmount.getAmount());
	}
	
	@Test
	public void testDecreaseAmount() {
		total.decreaseAmount();
		Amount expectedAmount = new Amount(0);
		Amount actualAmount = total.getTotalAmount();
		assertEquals(expectedAmount.getAmount(), actualAmount.getAmount());
	}
	
	private static void addItems() {
		sale.addItem(new Item(new ItemDTO(new Amount(100), VAT.getVAT_Rate_12(), "Item 1"), 1, new Quantity(12)));
		sale.addItem(new Item(new ItemDTO(new Amount(200), VAT.getVAT_Rate_12(), "Item 2"), 2, new Quantity(3)));
		sale.addItem(new Item(new ItemDTO(new Amount(300), VAT.getVAT_Rate_6(), "Item 3"), 3, new Quantity(18)));
		sale.addItem(new Item(new ItemDTO(new Amount(400), VAT.getVAT_Rate_6(), "ITem 4"), 4, new Quantity(2)));
	}

}
