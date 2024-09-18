package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun foo() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals("foo", app.items[0].name)

    }

    @Test
    fun pastSellBy() {
        val items = listOf(Item("foo", 1, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(9, app.items[0].quality)
        app.updateQuality()
        assertEquals(7, app.items[0].quality)
    }

    @Test
    fun negativeQuality() {
        val items = listOf(Item("foo", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBrie() {
        val items = listOf(Item("Aged Brie", 3, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertTrue(app.items[0].quality > 10)
    }

    @Test
    fun highQuality() {
        val items = listOf(Item("Aged Brie", 3, 50))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun sulfuras() {
        val items = listOf(Item("Sulfuras, Hand of Ragnaros", 10, 80))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(80, app.items[0].quality)
        assertEquals(10, app.items[0].sellIn)
    }

    @Test
    fun backstagePasses() {
        val items = listOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 10),
            Item("Backstage passes to Back to the Future: The Musical", 5, 10),
            Item("Backstage passes to the Lion King", 10, 10),
            Item("Backstage passes to a Lancashire Hotpots concert", 30, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].quality)
        assertEquals(13, app.items[1].quality)
        assertEquals(12, app.items[2].quality)
        assertEquals(11, app.items[3].quality)
    }

    @Test
    fun conjured() {
        val items = listOf(Item("Conjured cat", 10, 10))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(8, app.items[0].quality)
    }
}


