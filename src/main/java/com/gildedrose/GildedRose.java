package com.gildedrose;

import com.gildedrose.items.IGenericItem;

import java.util.Arrays;

class GildedRose {
    IGenericItem[] items;

    public GildedRose(IGenericItem[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(IGenericItem::update);
    }

}
