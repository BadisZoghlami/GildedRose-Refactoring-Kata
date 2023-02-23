package com.gildedrose.items;

import static com.gildedrose.utils.CommonUtils.MAX_QUALITY;
import static com.gildedrose.utils.CommonUtils.MIN_QUALITY;

/**
 * Strategy interface defining actions to be done
 */
public interface IGenericItem {

    void update();

    static boolean isPositive(int sellIn) {
        return sellIn >= 0;
    }

    static int updateReachedMaxQuality(int quality) {
        return quality > MAX_QUALITY ? MAX_QUALITY : quality;
    }

    static int updateReachedMinQuality(int quality) {
        return quality < MIN_QUALITY ? MIN_QUALITY : quality;
    }
}
