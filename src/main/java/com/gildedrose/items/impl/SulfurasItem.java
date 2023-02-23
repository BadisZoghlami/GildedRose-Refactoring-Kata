package com.gildedrose.items.impl;

import com.gildedrose.Item;
import com.gildedrose.items.IGenericItem;

/**
 * Legendary item, never has to be sold or decreases in Quality, always 80 and never alters
 */
public class SulfurasItem extends Item implements IGenericItem {

    public SulfurasItem(final String name, final int sellIn, final int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        // Do nothing, "Sulfuras", being a legendary item, never has to be sold or decreases in Quality
    }
}
