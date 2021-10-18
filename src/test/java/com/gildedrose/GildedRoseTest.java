package com.gildedrose;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

class GildedRoseTest {

    @Test
    void testname() {
        Item i = new Item("foo", 0, 0);
        GildedRose app = new GildedRose(new Item[]{i});
        app.updateQuality();
        assertThat(i.name, is("foo"));
    }
   @Test
   void agedBrie(){
        Item i = new Item("Aged Brie", 0, 0);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(lessThanOrEqualTo(50)));
        assertThat(oldquality,is(lessThan(i.quality)));
        assertThat(i.quality,is(greaterThanOrEqualTo(0)));
     //   assertThat(app.items[0].)

   }
  @Test
  void agedBriesellin(){
        Item i = new Item("Aged Brie", -1, 60);
        GildedRose app = new GildedRose(new Item[]{i});
        app.updateQuality();
        assertThat(i.quality,is(50));
  } 

 @Test
void handOfRagnarsellin(){
        Item i = new Item("Sulfuras, Hand of Ragnaros", -1, 80);
        GildedRose app = new GildedRose(new Item[]{i});
        app.updateQuality();
        assertThat(i.quality,is(80));
} 

  @Test 
  void sulfuras(){
        Item i = new Item("Sulfuras, Hand of Ragnaros", 50, 80);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(equalTo(oldquality)));
        assertThat(i.quality,is(equalTo(80)));
        assertThat(i.sellIn,is(50));
  }     

 @Test
 void backstage10(){
        Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 20);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(equalTo(oldquality+2)));
        assertThat(i.quality,is(lessThanOrEqualTo(50)));
  }

  @Test
 void backstage10over(){
        Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 7, 49);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(50));
  }

 @Test
 void backstage5(){
        Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 3,46);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(equalTo(oldquality+3)));
        assertThat(i.quality,is(lessThanOrEqualTo(50)));
 }

 @Test
 void backstage5over(){
        Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 3,49);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(50));
 }

  @Test
 void backstage15(){
        Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(equalTo(oldquality+1)));
        assertThat(i.quality,is(lessThanOrEqualTo(50)));
 }

   @Test
 void backstage15over(){
        Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 15, 49);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(50));
 }

   @Test
 void backstage0(){
        Item i = new Item("Backstage passes to a TAFKAL80ETC concert", 0, 49);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(0));
        assertThat(i.quality,is(greaterThanOrEqualTo(0)));
 }

  @Test
   void qualitytest(){
        Item i = new Item("foo", 20, 20);
        GildedRose app = new GildedRose(new Item[]{i});
        app.updateQuality();
        assertThat(i.quality,is(greaterThanOrEqualTo(0)));
        assertThat(i.quality,is(lessThanOrEqualTo(50)));
   } 

    @Test
   void qualitytest0(){
        Item i = new Item("foo",0, 20);
        GildedRose app = new GildedRose(new Item[]{i});
        int oldquality = i.quality;
        app.updateQuality();
        assertThat(i.quality,is(oldquality-2));
        assertThat(i.quality,is(greaterThanOrEqualTo(0)));
   } 

  @Test
  void qualityover50(){
        Item i = new Item("foo",0, 51);
        GildedRose app = new GildedRose(new Item[]{i});
        assertThat(i.quality,is(greaterThan(50)));
  }  

  @Test
  void conjuredlessthanzero(){
        Item i = new Item("Conjured",-4, 1);
        GildedRose app = new GildedRose(new Item[]{i});
        assertThat(i.quality,is(1));
        app.updateQuality();
        assertThat(i.quality,is(0));
  }

   @Test
  void conjuredmorethanzero(){
        Item i = new Item("Conjured",10, 10);
        GildedRose app = new GildedRose(new Item[]{i});
        assertThat(i.quality,is(10));
        app.updateQuality();
        assertThat(i.quality,is(8));
  }

   @Test
  void conjuredlessthanzero2(){
        Item i = new Item("Conjured",-4, 10);
        GildedRose app = new GildedRose(new Item[]{i});
        assertThat(i.quality,is(10));
        app.updateQuality();
        assertThat(i.quality,is(6));
  }

  @Test
  void toStringTest(){
         Item i = new Item("foo",0, 20);
        GildedRose app = new GildedRose(new Item[]{i});
        assertThat(i.toString(),is("foo, 0, 20"));
  } 

}
