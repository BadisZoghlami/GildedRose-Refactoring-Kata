package com.gildedrose.items.impl;

import com.gildedrose.Item;
import com.gildedrose.items.IGenericItem;

/**
 * At the end of each day our system lowers both values for every item
 * Once the sell by date has passed, Quality degrades twice as fast
 */
public class NormalItem extends Item implements IGenericItem {

    public NormalItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        sellIn-=1;
        // The Quality of an item is never negative
        if(quality <= 0) {
            return;
        }
        if(IGenericItem.isPositive(sellIn))  {
            quality-=1;
        } else if(!IGenericItem.isPositive(quality-=2)) {
                quality = 0;
        }
    }
}
