package com.gildedrose

class GildedRose(var items: List<Item>) {

    fun updateBrie(): Int {
        return 1
    }

    fun updateSulfuras(): Int {
        return 0
    }

    fun updateBackstagePass(item: Item): Int {
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
            if (item.name.lowercase().indexOf("sulfuras") == -1) {
                item.sellIn -= 1
            }

            var qualityChange = 0;

            if (item.name == "Aged Brie") {
                qualityChange = updateBrie();
            } else if (item.name.lowercase().contains("backstage passes")) {
                qualityChange = updateBackstagePass(item);
            } else if (item.name.lowercase().contains("sulfuras")) {
                qualityChange = updateSulfuras();
            } else {
                qualityChange = -1;
            }

            if (item.sellIn < 0) {
                qualityChange *= 2
            }

            if (item.name.lowercase().contains("conjured")) {
                qualityChange *= 2
            }

            item.quality += qualityChange

            if (item.quality > 50 && !item.name.lowercase().contains("sulfuras")) {
                item.quality = 50
            }
            if (item.quality < 0) {
                item.quality = 0
            }


        }
    }

}

