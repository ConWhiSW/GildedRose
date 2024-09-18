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
        for (i in items.indices) {
            if (items[i].name != "Aged Brie" && !items[i].name.startsWith("Backstage passes")) {
                if (items[i].quality > 0) {
                    if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                        items[i].quality -= 1
                        if (items[i].name.startsWith("Conjured")) {
                            items[i].quality -= 1
                        }
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality += 1

                    if (items[i].name.startsWith("Backstage passes")) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality += 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality += 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                items[i].sellIn -= 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != "Aged Brie") {
                    if (!items[i].name.startsWith("Backstage passes")) {
                        if (items[i].quality > 0) {
                            if (items[i].name != "Sulfuras, Hand of Ragnaros") {
                                items[i].quality -= 1
                            }
                        }
                    } else {
                        items[i].quality -= items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality += 1
                    }
                }
            }
        }
    }

}

