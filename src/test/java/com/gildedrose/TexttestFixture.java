package com.gildedrose;

import com.gildedrose.items.IGenericItem;
import com.gildedrose.items.impl.*;

public class TexttestFixture {
    public static void main(String[] args) {
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

        int days = 31;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            System.out.println("-------- day " + i + " --------");
            System.out.println("name, sellIn, quality");
            for (IGenericItem item : items) {
                System.out.println(item);
            }
            System.out.println();
            app.updateQuality();
        }
    }

}
