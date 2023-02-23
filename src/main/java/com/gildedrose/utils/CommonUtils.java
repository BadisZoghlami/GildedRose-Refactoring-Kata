package com.gildedrose.utils;

/**
 * Commonly used file for utility and static members
 */
public final class CommonUtils {
    private CommonUtils() {
        throw new IllegalStateException("Utility class");
    }

    /* Quality of an item is never more than 50 */
    public static final int MAX_QUALITY = 50;

    /* The Quality of an item is never negative */
    public static final int MIN_QUALITY = 0;

    /* Backstage Item */
    public static final int INCREASE_BACKSTAGE_PASSES_LESS_FIVE_DAYS = 3;
    public static final int INCREASE_BACKSTAGE_PASSES_LESS_TEN_DAYS = 2;
    public static final int BACKSTAGE_PASSES_TEN_DAYS_SELL_IN = 10;
    public static final int BACKSTAGE_PASSES_FIVE_DAYS_SELL_IN = 5;

}
