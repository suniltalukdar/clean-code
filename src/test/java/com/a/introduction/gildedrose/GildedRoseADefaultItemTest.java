package com.a.introduction.gildedrose;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class GildedRoseADefaultItemTest {
	private static final String DEFAULT_ITEM = "DEFAULT_ITEM";

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 1 when the item is not expired
	 * and sell in should decrease by 1.
	 * 
	 */
	@Test
	public void test_updateQuality_nonExpiredItem_defaultScenario() {
		int sellIn = 15;
		int quality = 3;
		int qualityFactor = 1;
		int sellInFactor = 1;
		GildedRose app = getGildedRoseDefaultScenario(sellIn, quality);
		
		app.updateQuality();
		
		Item item = app.items[0];
		verifyUpdateQuality(sellIn, quality, item, qualityFactor, sellInFactor);
	}

	private GildedRose getGildedRoseDefaultScenario(int sellIn, int quality) {
		Item item = new Item(DEFAULT_ITEM, sellIn, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}

	/**
	 * Method to test the variation in quality of the item for the non expired
	 * Item.
	 * 
	 * The quality should decrease by 2 when the item is expired(Sell in  < 0) and sell in should decrease by 1.
	 * 
	 */
	@Test
	public void testUpdateQualityForExpiredItem() {
		int sellIn = -1;
		int quality = 3;
		int qualityFactor = 2;
		int sellInFactor = 1;
		GildedRose app = getGildedRoseExpiredItem(sellIn, quality);
		
		app.updateQuality();
		
		Item item = app.items[0];
		verifyUpdateQuality(sellIn, quality, item, qualityFactor, sellInFactor);
	}

	private GildedRose getGildedRoseExpiredItem(int sellIn, int quality) {
		Item item = new Item(DEFAULT_ITEM, sellIn, quality);
		Item[] items = new Item[] { item };
		GildedRose app = new GildedRose(items);
		return app;
	}
	

	private void verifyUpdateQuality(int sellIn, int quality, Item item, int qualityFactor, int sellInFactor) {
		assertEquals(DEFAULT_ITEM, item.name);
		assertEquals(sellIn-sellInFactor, item.sellIn);
		assertEquals(quality-qualityFactor, item.quality);
	}
}