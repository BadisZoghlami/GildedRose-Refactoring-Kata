package com.gildedrose.items.impl;

import com.gildedrose.Item;
import com.gildedrose.items.IGenericItem;

/**
 * "Conjured" items degrade in Quality twice as fast as normal items
 */
public class ConjuredItem extends Item implements IGenericItem {

    public ConjuredItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        sellIn-=1;
        // The Quality of an item is never negative
        if(quality <= 0) {
            return;
        }
        if(IGenericItem.isPositive(sellIn))  {
            quality-=2;
        } else if(!IGenericItem.isPositive(quality-=2)) {
                quality = 0;
        }
        quality = IGenericItem.updateReachedMinQuality(quality);
    }
}
