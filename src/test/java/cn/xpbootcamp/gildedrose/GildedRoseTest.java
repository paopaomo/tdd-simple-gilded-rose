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
}
