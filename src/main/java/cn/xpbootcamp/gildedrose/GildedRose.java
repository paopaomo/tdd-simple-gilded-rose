package cn.xpbootcamp.gildedrose;

public class GildedRose {
    private GoodsType type;
    private int quality;
    private int sellIn;

    public GildedRose(GoodsType type, int quality, int sellIn) {
        this.type = type;
        this.quality = quality;
        this.sellIn = sellIn;
    }

    public int getUpdatedQuality() {
        return quality;
    }

    public int getUpdatedSellIn() {
        return sellIn;
    }

    public GoodsType getGoodsType() {
        return type;
    }
}


enum GoodsType {
    NORMAL, BACKSTAGE_PASS
}
