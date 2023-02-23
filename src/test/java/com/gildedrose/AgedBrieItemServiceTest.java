package com.gildedrose;

import com.gildedrose.items.IGenericItem;
import com.gildedrose.items.impl.AgedBrieItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class AgedBrieItemServiceTest {

    private IGenericItem[] items;
    private GildedRose app;
    @BeforeEach
    void setUp() {
        items = new IGenericItem[] {
            new AgedBrieItem("Aged Brie", 2, 0),
            new AgedBrieItem("Aged Brie", 2, 50)};

    }

   @Test
    void testUpdateQualityWithAgedBrieItemsWithDifferentSellInCases(){

       app = new GildedRose(items);
       app.updateQuality();

       // Given quality > 0 -> plus +1
       assertEquals(1, ((AgedBrieItem)app.items[0]).quality);

       // Given quality = 50 -> stay 50 quality can't go higher than 50
       assertEquals(50, ((AgedBrieItem)app.items[1]).quality);

    }
    @Test
    void testUpdateQualityWithAgedBrieItemsCasesNok(){

        app = new GildedRose(items);
        app.updateQuality();

        // Given quality = 50 -> stay 50 quality can't go higher than 50
        assertNotEquals(51, ((AgedBrieItem)app.items[1]).quality); // expected 50
    }

}
