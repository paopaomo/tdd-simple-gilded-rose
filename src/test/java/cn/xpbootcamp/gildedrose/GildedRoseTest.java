package cn.xpbootcamp.gildedrose;

import org.junit.Assert;
import org.junit.Test;

public class GildedRoseTest {
    @Test
    public void should_get_goods_info() {
        GildedRose goods = new GildedRose(GoodsType.NORMAL, 20, 10);
        Assert.assertEquals(20, goods.getUpdatedQuality());
        Assert.assertEquals(10, goods.getUpdatedSellIn());
        Assert.assertEquals(GoodsType.NORMAL, goods.getGoodsType());
    }

    @Test
    public void should_reduce_the_value_of_the_normal_goods_by_1_during_the_period_of_the_validity() {
        GildedRose goods = new GildedRose(GoodsType.NORMAL, 20, 10);
        goods.updateGoods();
        Assert.assertEquals(19, goods.getUpdatedQuality());
    }

    @Test
    public void should_reduce_the_value_of_the_normal_goods_by_2_that_are_not_within_the_validity_period() {
        GildedRose goods = new GildedRose(GoodsType.NORMAL, 20, -1);
        goods.updateGoods();
        Assert.assertEquals(18, goods.getUpdatedQuality());
    }

    @Test
    public void should_increase_the_value_of_the_backstage_pass_by_2_that_more_than_ten_days_before_the_show() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 20, 11);
        goods.updateGoods();
        Assert.assertEquals(22, goods.getUpdatedQuality());
    }
}
