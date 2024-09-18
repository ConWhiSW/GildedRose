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

            if (item.name != "Aged Brie" && !item.name.startsWith("Backstage passes")) {
                if (item.quality > 0) {
                    if (item.name != "Sulfuras, Hand of Ragnaros") {
                        item.quality -= 1
                        if (item.name.startsWith("Conjured")) {
                            item.quality -= 1
                        }
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality += 1

                    if (item.name.startsWith("Backstage passes")) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality += 1
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality += 1
                            }
                        }
                    }
                }
            }

            if (item.sellIn < 0) {
                if (item.name != "Aged Brie") {
                    if (!item.name.startsWith("Backstage passes")) {
                        if (item.quality > 0) {
                            if (item.name != "Sulfuras, Hand of Ragnaros") {
                                item.quality -= 1
                            }
                        }
                    } else {
                        item.quality -= item.quality
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality += 1
                    }
                }
            }
        }
    }

}

