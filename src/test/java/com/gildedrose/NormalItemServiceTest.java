package com.gildedrose;

import com.gildedrose.items.IGenericItem;
import com.gildedrose.items.impl.AgedBrieItem;
import com.gildedrose.items.impl.BackstageItem;
import com.gildedrose.items.impl.NormalItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class NormalItemServiceTest {

    private IGenericItem[] items;
    private GildedRose app;
    @BeforeEach
    void setUp() {
        items = new IGenericItem[] {
            new NormalItem("+5 Dexterity Vest", 10, 20),
            new NormalItem("Elixir of the Mongoose", -5, 6),
            new NormalItem("Elixir of the Mongoose", -5, 1)};

    }

   @Test
    void testUpdateQualityWithNormalItemsWithDifferentSellInCases(){

       app = new GildedRose(items);
       app.updateQuality();

       // Given SellIn > 0, quality 20 -> minus -1
       assertEquals(19, ((NormalItem)app.items[0]).quality);

       // Given SellIn is Negative, quality 6 -> minus -2
       assertEquals(4, ((NormalItem)app.items[1]).quality);

       // Given SellIn is Negative, quality 1 -> minus -2 but when quality is negative it must be initiated to 0, can't go bellow 0
       assertEquals(0, ((NormalItem)app.items[2]).quality);

    }
    @Test
    void testUpdateQualityWithNormalItemsWithDifferentSellInCasesNok(){

        app = new GildedRose(items);
        app.updateQuality();
        // Given SellIn is Negative and quality 1 -> minus -2 result must be initiated to 0, can't go bellow 0
        assertNotEquals(-1, ((NormalItem)app.items[2]).quality); // expected 0
    }

}
