package com.gildedrose;

import com.gildedrose.items.IGenericItem;
import com.gildedrose.items.impl.BackstageItem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BackstageItemServiceTest {

    private IGenericItem[] items;
    private GildedRose app;
    @BeforeEach
    void setUp() {
        items = new IGenericItem[] {
            new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 15, 21),
            new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 10, 21),
            new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 5, 21),
            new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 5, 50),
            new BackstageItem("Backstage passes to a TAFKAL80ETC concert", 0, 1)};

    }

   @Test
    void testUpdateQualityWithBackstageItemsWithDifferentSellInCases(){

       app = new GildedRose(items);
       app.updateQuality();

       // Given sellIn > 10 quality 21 -> plus +1
       assertEquals(22, ((BackstageItem)app.items[0]).quality);
       // Given sellIn < 10 quality 21 -> plus +2
       assertEquals(23, ((BackstageItem)app.items[1]).quality);
       // Given sellIn < 5 quality 21 -> plus +3
       assertEquals(24, ((BackstageItem)app.items[2]).quality);

       // Given sellIn < 10 quality = 49 -> +2 but stay 50 because quality can't go higher than 50
       assertEquals(50, ((BackstageItem)app.items[3]).quality);
       // Given sellIn < 5 quality = 49 -> +3 but stay 50 because quality can't go higher than 50
       assertEquals(50, ((BackstageItem)app.items[4]).quality);
       // Given quality = 50 -> stay 50 quality can't go higher than 50
       assertEquals(50, ((BackstageItem)app.items[5]).quality);

       // Given sellIn < 0 quality 21 -> quality go down to 0
       assertEquals(0, ((BackstageItem)app.items[6]).quality);

    }
    @Test
    void testUpdateQualityWithBackstageItemsWithDifferentSellInCasesNok(){

        app = new GildedRose(items);
        app.updateQuality();

        // Given sellIn < 10 quality = 49 -> +2 but stay 50 because quality can't go higher than 50
        assertNotEquals(51, ((BackstageItem)app.items[3]).quality);
        // Given sellIn < 5 quality = 49 -> +3 but stay 50 because quality can't go higher than 50
        assertNotEquals(52, ((BackstageItem)app.items[4]).quality);
        // Given sellIn < 5 quality = 50 -> +3 but stay 50 quality can't go higher than 50
        assertNotEquals(53, ((BackstageItem)app.items[5]).quality);
        // Given sellIn < 0 quality 1 -> quality should be 2 but go down to 0 because sellIn < 0
        assertNotEquals(2, ((BackstageItem)app.items[6]).quality);
    }

}
