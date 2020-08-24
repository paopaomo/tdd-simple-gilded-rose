package cn.xpbootcamp.gildedrose;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

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
    public void should_increase_the_value_of_the_backstage_pass_by_1_that_more_than_ten_days_before_the_show() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 20, 11);
        goods.updateGoods();
        Assert.assertEquals(21, goods.getUpdatedQuality());
    }

    @Test
    public void should_increase_the_value_of_the_backstage_pass_by_2_that_less_than_ten_days_and_more_than_five_days_before_the_show() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 20, 8);
        goods.updateGoods();
        Assert.assertEquals(22, goods.getUpdatedQuality());
    }

    @Test
    public void should_increase_the_value_of_the_backstage_pass_by_3_that_less_than_five_days_before_the_show() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 20, 3);
        goods.updateGoods();
        Assert.assertEquals(23, goods.getUpdatedQuality());
    }

    @Test
    public void should_the_value_of_the_backstage_pass_is_0_that_the_show_is_over() {
        GildedRose goods = new GildedRose(GoodsType.BACKSTAGE_PASS, 20, -3);
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

    @ParameterizedTest
    @MethodSource
    void should_update_the_normal_goods_correctly(GoodsType type, int sellIn,
                                                  int quality,
                                                  int updatedSellIn, int updatedQuality) {
        GildedRose goods = new GildedRose(type, quality, sellIn);
        int num_of_days = sellIn - updatedSellIn;
        while(num_of_days > 0) {
            goods.updateGoods();
            num_of_days -= 1;
        }
        Assert.assertEquals(updatedQuality, goods.getUpdatedQuality());
    }
    static List<Arguments> should_update_the_normal_goods_correctly() {
        return List.of(
                Arguments.arguments(GoodsType.NORMAL, 10, 20, 9, 19),
                Arguments.arguments(GoodsType.NORMAL, 2, 0, 1, 0),
                Arguments.arguments(GoodsType.NORMAL, 3, 6, 2 , 5),
                Arguments.arguments(GoodsType.NORMAL, 0, 6, -1 , 4),
                Arguments.arguments(GoodsType.NORMAL, -1, 6, -2 , 4),
                Arguments.arguments(GoodsType.BACKSTAGE_PASS, 15, 20, 14, 21),
                Arguments.arguments(GoodsType.BACKSTAGE_PASS, 10, 45, 9, 47),
                Arguments.arguments(GoodsType.BACKSTAGE_PASS, 9, 45, 8, 47),
                Arguments.arguments(GoodsType.BACKSTAGE_PASS, 10, 49, 9, 50),
                Arguments.arguments(GoodsType.BACKSTAGE_PASS, 10, 50, 9, 50),
                Arguments.arguments(GoodsType.BACKSTAGE_PASS, 5, 49, 4, 50),
                Arguments.arguments(GoodsType.BACKSTAGE_PASS, 5, 45, 4, 48),
                Arguments.arguments(GoodsType.BACKSTAGE_PASS, 1, 20, 0, 23),
                Arguments.arguments(GoodsType.BACKSTAGE_PASS, 0, 20, -1, 0)
        );
    }
}
