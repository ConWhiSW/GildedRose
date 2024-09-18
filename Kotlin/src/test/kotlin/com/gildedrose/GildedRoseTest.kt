package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
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

}


