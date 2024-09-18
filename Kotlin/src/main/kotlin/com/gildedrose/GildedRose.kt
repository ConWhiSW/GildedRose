package com.gildedrose

class GildedRose(var items: List<Item>) {
    private fun updateBrie(): Int {
        return 1
    }

    private fun updateSulfuras(): Int {
        return 0
    }

    private fun updateBackstagePass(item: Item): Int {
        if (item.sellIn > 10) {
            return 1
        }
        if (item.sellIn > 5) {
            return 2
        }
        if (item.sellIn > 0) {
            return 3
        }
        return -1*item.quality
    }

    fun updateQuality() {
        for (item in items) {

            val lcName = item.name.lowercase()
            var sulfuras = false
            var backstagePass = false
            var conjured = false

            when {
                lcName.contains("sulfuras") -> {
                    sulfuras = true
                }
                lcName.contains("backstage passes") -> {
                    backstagePass = true
                }
                lcName.contains("conjured") -> {
                    conjured = true
                }
            }

            if (!sulfuras) {
                item.sellIn -= 1
            }

            var qualityChange: Int

            if (item.name == "Aged Brie") {
                qualityChange = updateBrie()
            } else if (backstagePass) {
                qualityChange = updateBackstagePass(item)
            } else if (sulfuras) {
                qualityChange = updateSulfuras()
            } else {
                qualityChange = -1
            }

            if (item.sellIn < 0) {
                qualityChange *= 2
            }

            if (conjured) {
                qualityChange *= 2
            }

            item.quality += qualityChange

            if (item.quality > 50 && !sulfuras) {
                item.quality = 50
            }
            if (item.quality < 0) {
                item.quality = 0
            }


        }
    }

}

