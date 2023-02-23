package com.gildedrose.items.impl;

import com.gildedrose.Item;
import com.gildedrose.items.IGenericItem;

import static com.gildedrose.utils.CommonUtils.*;

/**
 * Like aged brie, increases in Quality as its SellIn value approaches
 * Quality increases by 2 when there are 10 days or less and by 3 when there are 5 days or less
 * but Quality drops to 0 after the concert
 */
public class BackstageItem extends Item implements IGenericItem {

    public BackstageItem(final String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        sellIn-=1;
        if(sellIn < 0) {
            quality = 0;
            return;
        } else if(quality >= MAX_QUALITY) {
            return;
        }

        if(sellIn < BACKSTAGE_PASSES_FIVE_DAYS_SELL_IN) {
            quality+=INCREASE_BACKSTAGE_PASSES_LESS_FIVE_DAYS;
        } else if(sellIn < BACKSTAGE_PASSES_TEN_DAYS_SELL_IN) {
            quality+= INCREASE_BACKSTAGE_PASSES_LESS_TEN_DAYS;
        } else {
            quality+=1;
        }
        quality = IGenericItem.updateReachedMaxQuality(quality);

    }
}
