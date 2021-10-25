package com.gildedrose;

class GildedRose {
  Item[] items;

  GildedRose(Item[] item) {
    this.items = item;
  }

  private void updateBrie(Item item) {
    item.updateQuality(1);;
  }

  private void updateSulfuras(Item item) {
    item.quality = 80;
  }

  private void updateBackstage(Item item) {
    if (item.sellIn < 11) {
      item.updateQuality(1);;
    }
    if (item.sellIn < 6) {
      item.updateQuality(1);;
    }
    if (item.sellIn <= 0) {
      item.quality = -1;
    }
  }

  private void updateConjured(Item item) {
    if (item.sellIn <= 0) {
      item.updateQuality(-2);;
    }
  }

  private void updateFoo(Item item) {
    if (item.sellIn <= 0) {
      item.updateQuality(-1);;
    }
  }

  private void updateSellQual(Item item, int qualityChange) {
    item.sellIn -= 1;

    item.updateQuality(qualityChange);;
  }

  private void update(Item item) {
    switch (item.name) {
      case "Aged Brie":
        updateBrie(item);
        updateSellQual(item, 0);
        break;

      case "Backstage passes to a TAFKAL80ETC concert":
        updateBackstage(item);
        updateSellQual(item, 1);
        break;

      case "Sulfuras, Hand of Ragnaros":
        updateSulfuras(item);
        break;

      case "Conjured":
        updateConjured(item);
        updateSellQual(item, -2);
        break;

      default:
        updateFoo(item);
        updateSellQual(item, -1);
        break;
    }
  }

  public void updateQuality() {

    for (Item items : items) {
      update(items);
    }
  }
}
