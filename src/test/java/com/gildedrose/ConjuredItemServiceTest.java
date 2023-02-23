package com.gildedrose;

import com.gildedrose.items.IGenericItem;
import com.gildedrose.items.impl.ConjuredItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class ConjuredItemServiceTest {

    private IGenericItem[] items;
    private GildedRose app;

    @BeforeEach
    void setUp() {
        items = new IGenericItem[] {
            new ConjuredItem("Conjured Mana Cake", 3, 7),
            new ConjuredItem("Conjured Mana Cake", -3, 7),
            new ConjuredItem("Conjured Mana Cake", -3, 1)};

    }

   @Test
    void testUpdateQualityWithConjuredItemsWithDifferentSellInCases(){

       app = new GildedRose(items);
       app.updateQuality();

       // Given SellIn > 0, quality 7 -> minus -2
       assertEquals(5, ((ConjuredItem)app.items[0]).quality);

       // Given SellIn is Negative, quality 7 -> minus -2
       assertEquals(5, ((ConjuredItem)app.items[1]).quality);

       // Given SellIn is Negative, quality 1 -> minus -2 but when quality is negative it must be initiated to 0, can't go bellow 0
       assertEquals(0, ((ConjuredItem)app.items[2]).quality);

    }
    @Test
    void testUpdateQualityWithConjuredItemsWithDifferentSellInCasesNok(){

        app = new GildedRose(items);
        app.updateQuality();
        // Given SellIn is Negative and quality 1 -> minus -2 result must be initiated to 0, can't go bellow 0
        assertNotEquals(-1, ((ConjuredItem)app.items[2]).quality); // expected 0
    }

}
