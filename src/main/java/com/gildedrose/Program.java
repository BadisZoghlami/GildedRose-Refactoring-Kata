package com.gildedrose;

import com.gildedrose.items.IGenericItem;
import com.gildedrose.items.impl.*;

public class Program {

	public static void main(String... args) {
		System.out.println("OMGHAI!");

		IGenericItem[] items = new IGenericItem[] {
				new NormalItem("+5 Dexterity Vest", 10, 21),
				new AgedBrieItem("Aged Brie", 2, 0),
				new NormalItem("Elixir of the Mongoose", 5, 6),
				new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80),
				new SulfurasItem("Sulfuras, Hand of Ragnaros", -1, 80),
				new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 15, 21),
				new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
				new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
				// this conjured item does not work properly yet
				new ConjuredItem("Conjured Mana Cake", 5, 7)
				};

		GildedRose app = new GildedRose(items);

		for (int i = 0; i < 31; i++) {
			System.out.println("-------- day " + i + " --------");
			System.out.println("name, sellIn, quality");
			for (int j = 0; j < items.length; j++) {
				System.out.println(items[j]);
			}
			System.out.println("");
			app.updateQuality();
		}
	}
}
