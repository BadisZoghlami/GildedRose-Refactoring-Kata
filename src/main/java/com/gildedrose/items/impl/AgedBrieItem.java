package com.gildedrose.items.impl;

import com.gildedrose.Item;
import com.gildedrose.items.IGenericItem;

/**
 * Increases in Quality the older it gets
 */
public class AgedBrieItem extends Item implements IGenericItem {

    public AgedBrieItem(final String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        sellIn-=1;
        if(quality >= 50) {
            return;
        }
        quality+=1;
    }
}
