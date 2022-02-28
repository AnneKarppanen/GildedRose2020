package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	@Test
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	

	@Test
	public void ItemSellInDecresesEachDayTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 5, 7));
		inn.oneDay();
		
		//access a list of items, get the sellIn of the item
		List<Item> items = inn.getItems();
		int sellIn = items.get(0).getSellIn();
		
		//assert sellIn has decreased by one
		assertEquals("Failed sellIn for Elixir of Mongoose", 4, sellIn);
		
		inn.oneDay();
		
		//get the sellIn of the item
	    sellIn = items.get(0).getSellIn();
		
		//assert sellIn has decreased by one
		assertEquals("Failed sellIn for Elixir of Mongoose", 3, sellIn);
		
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		//get the sellIn of the item
		sellIn = items.get(0).getSellIn();
		
		//assert sellIn has decreased by three
		assertEquals("Failed sellIn for Elixir of Mongoose", 0, sellIn);
		
		inn.oneDay();
		inn.oneDay();
		
		
		//get the sellIn of the item
		sellIn = items.get(0).getSellIn();
				
		
		//assert sellIn has decreased by two
		assertEquals("Failed sellIn for Elixir of Mongoose", -2, sellIn);
		
	}
	
	
	
	
	@Test
	public void ItemQualityDecreaseDoublesAfterSellByTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 3, 6));
		inn.oneDay();
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by two
		assertEquals("Failed quality for Conjures Mana Cake", 4, quality);
		inn.oneDay();
		
		//get the sellIn of the item
		quality = items.get(0).getQuality();
				
		//assert quality has decreased by one
		assertEquals("Failed quality for Conjures Mana Cake", 3, quality);
		inn.oneDay();
		
		//get the sellIn of the item
		quality = items.get(0).getQuality();
		
		//assert quality has decreased by two
		assertEquals("Failed quality for Conjures Mana Cake", 1, quality);
		
	}
	
	@Test
	public void ItemQualityIsNotNegativeTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 3, 6));
		
		for(int i = 0; i <=  5; i++) {
			inn.oneDay();
		}
		
		//access a list of items, get the quality of the item
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by two
		assertEquals("Failed quality for Conjures Mana Cake", 0, quality);
		inn.oneDay();
		
		//get the quality of the item
		quality = items.get(0).getQuality();
						
		
		//assert quality has decreased by two
		assertEquals("Failed quality for Conjures Mana Cake", 0, quality);

	}
	
	@Test
	public void QualityOfSulfurasDoesNotChangeTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by two
		assertEquals("Failed quality for Sulfuras", 80, quality);
		inn.oneDay();
		
		//access a list of items, get the sellIn of the item
		quality = items.get(0).getQuality();
				
		//assert quality has decreased by one
		assertEquals("Failed quality for Sulfuras", 80, quality);
		inn.oneDay();
		
		//access a list of items, get the sellIn of the item
		quality = items.get(0).getQuality();
		
		//assert quality has decreased by two
		assertEquals("Failed quality for Sulfuras", 80, quality);
		
	}
	
	@Test
	public void SellInOfSulfurasDoesNotChangeTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int sellIn = items.get(0).getSellIn();
		
		//assert quality has decreased by two
		assertEquals("Failed quality for Sulfuras", 0, sellIn);
		inn.oneDay();
		
		//get the sellIn of the item
		sellIn = items.get(0).getSellIn();
				
		//assert quality has decreased by one
		assertEquals("Failed quality for Sulfuras", 0, sellIn);
		inn.oneDay();
		
		//get the sellIn of the item
		sellIn = items.get(0).getSellIn();
		
		//assert quality has decreased by two
		assertEquals("Failed quality for Sulfuras", 0, sellIn);
		
	}
	
	@Test
	public void QualityOfBrieIncreasesUntil50Test() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 2, 0));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by one
		assertEquals("Failed quality for Brie", 1, quality);
		
		inn.oneDay();
		
		//get the quality of the item
		quality = items.get(0).getQuality();
				
		//assert quality has increased by one
		assertEquals("Failed quality for Brie", 2, quality);
		inn.oneDay();
		
		//get the qualtity of the item
		quality = items.get(0).getQuality();
		
		//assert quality has increased by one
		assertEquals("Failed quality for Brie", 3, quality);
		
		inn.oneDay();
		
		//get the quality of the item
		quality = items.get(0).getQuality();
		
		//assert quality has increased by one
		assertEquals("Failed quality for Brie", 4, quality);
		
		
		for (int i = 0; i <= 46; i++) {
			inn.oneDay();
		}
		
		//access a list of items, get the sellIn of the item
		quality = items.get(0).getQuality();
				
		//assert quality has decreased by two
		assertEquals("Failed quality for Brie", 50, quality);
		
		inn.oneDay();
		
		//access a list of items, get the sellIn of the item
		quality = items.get(0).getQuality();
						
		//assert quality has decreased by two
		assertEquals("Failed quality for Brie", 50, quality);
		
	}
	
	@Test
	public void QualityOfPassesIncreasesBy1Until10DaysBeforeTest() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by one
		assertEquals("Failed quality for Passes", 21, quality);
		
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		//get the quality of the item
		quality = items.get(0).getQuality();
				
		//assert quality has increased by three
		assertEquals("Failed quality for Passes", 24, quality);
		inn.oneDay();
		
		//get the qualtity of the item
		quality = items.get(0).getQuality();
		
		//assert quality has increased by one
		assertEquals("Failed quality for Passes", 25, quality);
		
		inn.oneDay();
		
		//get the quality of the item
		quality = items.get(0).getQuality();
		
		//assert quality has increased by two
		assertEquals("Failed quality for Passes", 27, quality);
		
	}
	
	@Test
	public void QualityOfPassesIncreasesBy2From10DaysBeforeTill5DaysBeforeTest() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 25));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by two
		assertEquals("Failed quality for Passes", 27, quality);
		
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		//get the quality of the item
		quality = items.get(0).getQuality();
				
		//assert quality has increased by six
		assertEquals("Failed quality for Passes", 33, quality);
		inn.oneDay();
		
		//get the qualtity of the item
		quality = items.get(0).getQuality();
		
		//assert quality has increased by one
		assertEquals("Failed quality for Passes", 35, quality);
		
		inn.oneDay();
		
		//get the quality of the item
		quality = items.get(0).getQuality();
		
		//assert quality has increased by three
		assertEquals("Failed quality for Passes", 38, quality);
		
	}
	
	@Test
	public void QualityOfPassesIncreasesBy3From5DaysBeforeTillConcertTest() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 35));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has increased by three
		assertEquals("Failed quality for Passes", 38, quality);
		
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		//get the quality of the item
		quality = items.get(0).getQuality();
				
		//assert quality has increased by nine
		assertEquals("Failed quality for Passes", 47, quality);
		inn.oneDay();
		
		//get the qualtity of the item
		quality = items.get(0).getQuality();
		
		//assert quality has increased by three
		assertEquals("Failed quality for Passes", 50, quality);
		
	}
	
	@Test
	public void QualityOfPassesDropsTo0AfterConcertTest() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 50));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has dropped to 0
		assertEquals("Failed quality for Passes", 0, quality);
		
		inn.oneDay();
		
		//get the quality of the item
		quality = items.get(0).getQuality();
				
		//assert quality is still 0
		assertEquals("Failed quality for Passes", 0, quality);
		inn.oneDay();
		
	}
	
	@Test
	public void QualityOfPassesDoesNotIncreaseOver50Test() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 13, 49));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49));
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 4, 49));
		
		inn.oneDay();
		
		//access a list of items
		List<Item> items = inn.getItems();
	
		//assert quality increases to 50
		assertEquals("Failed quality for Passes 12 days before concert", 50, items.get(0).getQuality());
		assertEquals("Failed quality for Passes 8 days before concert", 50, items.get(1).getQuality());
		assertEquals("Failed quality for Passes 8 days before concert", 50, items.get(2).getQuality());
		
		inn.oneDay();
			
		//assert quality does not increase over 50
		assertEquals("Failed quality for Passes 11 days before concert", 50, items.get(0).getQuality());
		assertEquals("Failed quality for Passes 8 days before concert", 50, items.get(1).getQuality());
		assertEquals("Failed quality for Passes 8 days before concert", 50, items.get(2).getQuality());
	}
	
	
	@Test
	public void NoItemsInGuildedRoseTest() {
		
		//create an inn and an empty list and check size
		GildedRose inn = new GildedRose();
		List<Item> items = inn.getItems();
		assertEquals("GildedRose not empty", 0, items.size());
		
	}
	
	@Test
	public void GildedRoseAddsDifferentItemsTest() {
		
		//create an inn and a list and check size
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
	    inn.setItem(new Item("Aged Brie", 2, 0));
		
		List<Item> items = inn.getItems();
		assertEquals("Failed to add items", 2, items.size());
		
		// add items
		inn.setItem(new Item("Elixir of the Mongoose", 5, 7));
	    inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
	    
	    // check size
	    items = inn.getItems();
	    assertEquals("Failed to add items", 4, items.size());
	    
	    // add items
	    inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
	    inn.setItem(new Item("Conjured Mana Cake", 3, 6));
	    inn.setItem(new Item("Conjured Mana Cake", 3, 6));	
	    
	    // check size
	    items = inn.getItems();
	    assertEquals("Failed to add items", 7, items.size());
	    
	}
	
	@Test
	public void GildedRoseChangesQualityOfDifferentItemsTest() {
		
		//create an inn and a list and check size
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
	    inn.setItem(new Item("Aged Brie", 2, 0));
		inn.setItem(new Item("Elixir of the Mongoose", 5, 7));
	    inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
	    
	    // check qualities
	    List<Item> items = inn.getItems();
	    assertEquals("Incorrect quality for Dexterity Vest", 20, items.get(0).getQuality());
	    assertEquals("Incorrect quality for Aged Brie", 0, items.get(1).getQuality());
	    assertEquals("Incorrect quality for Elixir", 7, items.get(2).getQuality());
	    assertEquals("Incorrect quality for Sulfuras", 80, items.get(3).getQuality());
	    
	    inn.oneDay();
	    
	    // check qualities
	    items = inn.getItems();
	    assertEquals("Incorrect quality for Dexterity Vest", 19, items.get(0).getQuality());
	    assertEquals("Incorrect quality for Aged Brie", 1, items.get(1).getQuality());
	    assertEquals("Incorrect quality for Elixir", 6, items.get(2).getQuality());
	    assertEquals("Incorrect quality for Sulfuras", 80, items.get(3).getQuality());
	    
	}
	
	@Test
	public void MainAddsItemsToGuildedRoseTest() {
		
		GildedRose inn = new GildedRose();
		GildedRose.main(new String[] {});
		List<Item> items = inn.getItems();
		assertEquals("Failed to add items", 6, items.size());
	}
	
	@Test
	public void UpdateQualityWorksInMain() {
		GildedRose inn = new GildedRose();
		GildedRose.main(new String[] {});
		List<Item> items = inn.getItems();
		assertEquals("Failed to add items", 6, items.size());
		
		assertEquals("Incorrect quality for Dexterity Vest", 19, items.get(0).getQuality());
	    assertEquals("Incorrect quality for Aged Brie", 1, items.get(1).getQuality());
	    assertEquals("Incorrect quality for Elixir", 6, items.get(2).getQuality());
	    assertEquals("Incorrect quality for Sulfuras", 80, items.get(3).getQuality());
	}
	
	

	
}
