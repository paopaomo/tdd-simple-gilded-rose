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

    private void updateBackstagePassGoods() {
        // TODO
    }

    private void updateNormalGoods() {
        if(sellIn >= 0) {
            quality -= 1;
        } else {
            quality -= 2;
        }
    }

    public void updateGoods() {
        switch (type) {
            case BACKSTAGE_PASS:
                updateBackstagePassGoods();
                break;
            case NORMAL:
            default:
                updateNormalGoods();
                break;
        }
    }
}


enum GoodsType {
    NORMAL, BACKSTAGE_PASS
}
