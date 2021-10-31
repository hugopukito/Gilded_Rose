package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

  @Test
  void AgedBrie() {
    Item i = new Item("Aged Brie", 0, 0);
    GildedRose app = new GildedRose(new Item[]{i});
    int oldquality = i.quality;
    app.updateQuality();
    assertThat(i.quality,is(lessThanOrEqualTo(50)));
    assertThat(oldquality,is(lessThan(i.quality)));
    assertThat(i.quality,is(greaterThanOrEqualTo(0)));
  }

  @Test
  void AgedBrieSellin() {
    Item i = new Item("Aged Brie", -1, 60);
    GildedRose app = new GildedRose(new Item[]{i});
    app.updateQuality();
    assertThat(i.quality,is(50));
  }

  @Test
  void HandOfRagnarosSellin() {
    Item i = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
    GildedRose app = new GildedRose(new Item[]{i});
    app.updateQuality();
    assertThat(i.quality,is(80));
  }

  @Test 
  void Sulfuras() {
    Item i = new Item("Sulfuras, Hand of Ragnaros", 50, 80);
    GildedRose app = new GildedRose(new Item[]{i});
    int oldquality = i.quality;
    app.updateQuality();
    assertThat(i.quality,is(equalTo(oldquality)));
    assertThat(i.quality,is(equalTo(80)));
    assertThat(i.sellIn,is(50));
  }

  @Test
  void Backstage_10() {
    Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 20);
    GildedRose app = new GildedRose(new Item[]{i});
    int oldquality = i.quality;
    app.updateQuality();
    assertThat(i.quality,is(equalTo(oldquality+2)));
    assertThat(i.quality,is(lessThanOrEqualTo(50)));
  }

  @Test
  void Backstage_10_max_quality() {
    Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 49);
    GildedRose app = new GildedRose(new Item[]{i});
    app.updateQuality();
    assertThat(i.quality,is(50));
  }

  @Test
  void Backstage_5() {
    Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 46);
    GildedRose app = new GildedRose(new Item[]{i});
    int oldquality = i.quality;
    app.updateQuality();
    assertThat(i.quality,is(equalTo(oldquality+3)));
    assertThat(i.quality,is(lessThanOrEqualTo(50)));
  }

 @Test
  void Backstage_5_max_quality() {
    Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49);
    GildedRose app = new GildedRose(new Item[]{i});
    app.updateQuality();
    assertThat(i.quality,is(50));
  }

  @Test
  void Backstage_15() {
    Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
    GildedRose app = new GildedRose(new Item[]{i});
    int oldquality = i.quality;
    app.updateQuality();
    assertThat(i.quality,is(equalTo(oldquality+1)));
    assertThat(i.quality,is(lessThanOrEqualTo(50)));
  }

  @Test
  void Backstage_15_max_quality() {
    Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 49);
    GildedRose app = new GildedRose(new Item[]{i});
    app.updateQuality();
    assertThat(i.quality,is(50));
  }

  @Test
  void Backstage_0() {
    Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49);
    GildedRose app = new GildedRose(new Item[]{i});
    app.updateQuality();
    assertThat(i.quality,is(0));
    assertThat(i.quality,is(greaterThanOrEqualTo(0)));
  }

  @Test
  void Quality_test() {
  Item i = new Item("foo", 20, 20);
  GildedRose app = new GildedRose(new Item[]{i});
  app.updateQuality();
  assertThat(i.quality,is(greaterThanOrEqualTo(0)));
  assertThat(i.quality,is(lessThanOrEqualTo(50)));
  }

  @Test
  void Quality_test_0() {
    Item i = new Item("foo", 0, 20);
    GildedRose app = new GildedRose(new Item[]{i});
    int oldquality = i.quality;
    app.updateQuality();
    assertThat(i.quality,is(oldquality-2));
    assertThat(i.quality,is(greaterThanOrEqualTo(0)));
  } 

  @Test
  void Quality_over_50() {
    Item i = new Item("foo", 0, 51);
    assertThat(i.quality,is(greaterThan(50)));
  }

  @Test
  void Conjured_less_than_0() {
    Item i = new Item("Conjured", -4, 1);
    GildedRose app = new GildedRose(new Item[]{i});
    assertThat(i.quality,is(1));
    app.updateQuality();
    assertThat(i.quality,is(0));
  }

  @Test
  void Conjured_more_than_0() {
    Item i = new Item("Conjured", 10, 10);
    GildedRose app = new GildedRose(new Item[]{i});
    assertThat(i.quality,is(10));
    app.updateQuality();
    assertThat(i.quality,is(8));
  }

  @Test
  void Conjured_less_than_0_bis() {
    Item i = new Item("Conjured", -4, 10);
    GildedRose app = new GildedRose(new Item[]{i});
    assertThat(i.quality,is(10));
    app.updateQuality();
    assertThat(i.quality,is(6));
  }

  @Test
  void to_String() {
    Item i = new Item("foo", 0, 20);
    assertThat(i.toString(),is("foo, 0, 20"));
  }

}
