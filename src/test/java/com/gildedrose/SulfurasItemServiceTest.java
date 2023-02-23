package com.gildedrose;

import com.gildedrose.items.IGenericItem;
import com.gildedrose.items.impl.SulfurasItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class SulfurasItemServiceTest {

    private IGenericItem[] items;
    private GildedRose app;
    @BeforeEach
    void setUp() {
        //app = new GildedRose(items);
        items = new IGenericItem[] {
            new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80),
            new SulfurasItem("Sulfuras, Hand of Ragnaros", -1, 80)};

    }

   @Test
    void testUpdateQualityWithSulfurasItemsWithDifferentSellInCases(){

       // Given sellIn > 0 quality 80 -> do nothing
       app = new GildedRose(items);
       app.updateQuality();

       assertEquals(80, ((SulfurasItem)app.items[0]).quality);

       // Given sellIn < 0 quality 80 -> do nothing
       assertEquals(80, ((SulfurasItem)app.items[1]).quality);

    }
    @Test
    void testUpdateQualityWithSulfurasItemsCasesNok() {

        app = new GildedRose(items);
        app.updateQuality();

        // Given sellIn < 0 quality 80 -> do nothing
        assertNotEquals(79, ((SulfurasItem) app.items[1]).quality);
    }

}
