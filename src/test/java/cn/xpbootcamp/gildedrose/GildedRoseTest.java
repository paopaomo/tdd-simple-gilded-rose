package cn.xpbootcamp.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void should_decrease_1_when_update_quality_given_normal_goods_within_the_warranty_period() {
        GildedRose goods = new GildedRose(GoodsType.NORMAL, 10, 10);
        goods.updateGoods();
        Assert.assertEquals(9, goods.getUpdatedQuality());
    }

    @Test
    public void should_decrease_2_when_update_quality_given_normal_goods_are_not_within_the_warranty_period() {
        GildedRose goods = new GildedRose(GoodsType.NORMAL, 10, -1);
        goods.updateGoods();
        Assert.assertEquals(8, goods.getUpdatedQuality());
    }

    @Test
    public void should_increase_1_when_update_quality_given_backstage_pass_more_than_ten_days_before_the_show() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 13);
        goods.updateGoods();
        Assert.assertEquals(11, goods.getUpdatedQuality());
    }

    @Test
    public void should_increase_2_when_update_quality_given_backstage_pass_no_more_than_ten_days_and_more_than_five_days_before_the_show() {
        GildedRose goods1 = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 10);
        goods1.updateGoods();
        Assert.assertEquals(12, goods1.getUpdatedQuality());

        GildedRose goods2 = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 8);
        goods2.updateGoods();
        Assert.assertEquals(12, goods2.getUpdatedQuality());
    }

    @Test
    public void should_increase_3_when_update_quality_given_backstage_pass_no_more_than_five_days_and_more_than_one_days_before_the_show() {
        GildedRose goods1 = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 5);
        goods1.updateGoods();
        Assert.assertEquals(13, goods1.getUpdatedQuality());

        GildedRose goods2 = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, 3);
        goods2.updateGoods();
        Assert.assertEquals(13, goods2.getUpdatedQuality());
    }

    @Test
    public void should_quality_is_zero_when_update_quality_given_backstage_pass_is_over() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 10, -3);
        goods.updateGoods();
        Assert.assertEquals(0, goods.getUpdatedQuality());
    }

    @Test
    public void should_the_minimum_quality_of_the_goods_is_0_when_update_quality_given_normal_goods_with_zero_quality() {
        GildedRose goods = new GildedRose(GoodsType.NORMAL, 0, 2);
        goods.updateGoods();
        Assert.assertEquals(0, goods.getUpdatedQuality());
    }

    @Test
    public void should_the_maximum_quality_of_the_goods_is_50_when_update_quality_given_backstage_pass_with_49_quality() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 49, 2);
        goods.updateGoods();
        Assert.assertEquals(50, goods.getUpdatedQuality());
    }
}
