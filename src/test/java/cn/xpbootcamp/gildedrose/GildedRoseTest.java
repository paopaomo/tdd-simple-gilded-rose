package cn.xpbootcamp.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void should_decrease_the_value_of_the_normal_goods_by_1_within_the_warranty_period() {
        GildedRose goods = new GildedRose(GoodsType.NORMAL, 10, 10);
        goods.updateGoods();
        Assert.assertEquals(9, goods.getUpdatedQuality());
    }

    @Test
    public void should_decrease_the_value_of_the_normal_goods_by_2_that_are_not_within_the_warranty_period() {
        GildedRose goods = new GildedRose(GoodsType.NORMAL, 10, -1);
        goods.updateGoods();
        Assert.assertEquals(8, goods.getUpdatedQuality());
    }

    @Test
    public void should_increase_the_value_of_the_backstage_pass_by_1_that_more_than_ten_days_before_the_show() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 13);
        goods.updateGoods();
        Assert.assertEquals(11, goods.getUpdatedQuality());
    }

    @Test
    public void should_increase_the_value_of_the_backstage_pass_by_2_that_no_more_than_ten_days_and_more_than_five_days_before_the_show() {
        GildedRose goods1 = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 10);
        goods1.updateGoods();
        Assert.assertEquals(12, goods1.getUpdatedQuality());

        GildedRose goods2 = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 8);
        goods2.updateGoods();
        Assert.assertEquals(12, goods2.getUpdatedQuality());
    }

    @Test
    public void should_increase_the_value_of_the_backstage_pass_by_3_that_no_more_than_five_days_before_the_show() {
        GildedRose goods1 = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 5);
        goods1.updateGoods();
        Assert.assertEquals(13, goods1.getUpdatedQuality());

        GildedRose goods2 = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 3);
        goods2.updateGoods();
        Assert.assertEquals(13, goods2.getUpdatedQuality());
    }

    @Test
    public void should_the_value_of_the_backstage_pass_is_0_that_the_show_is_over() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, -3);
        goods.updateGoods();
        Assert.assertEquals(0, goods.getUpdatedQuality());
    }

    @Test
    public void should_the_minimum_of_the_goods_is_0() {
        GildedRose goods = new GildedRose(GoodsType.NORMAL, 0, 2);
        goods.updateGoods();
        Assert.assertEquals(0, goods.getUpdatedQuality());
    }

    @Test
    public void should_the_maximum_of_the_goods_is_50() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 49, 2);
        goods.updateGoods();
        Assert.assertEquals(50, goods.getUpdatedQuality());
    }
}
