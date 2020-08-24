package cn.xpbootcamp.gildedrose;

public class GildedRose {
    private GoodsType type;
    private int quality;
    private int sellIn;
    final int MAX_QUALITY = 50;
    final int MIN_QUALITY = 0;

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

    private void increasePrice(int quality, int diff) {
        this.quality = Math.min(quality + diff, MAX_QUALITY);
    }

    private void decreasePrice(int quality, int diff) {
        this.quality = Math.max(quality - diff, MIN_QUALITY);
    }

    private void updateBackstagePassGoods() {
        if(sellIn > 10) {
            increasePrice(quality, 2);
        } else if(sellIn > 0 && sellIn < 5) {
            increasePrice(quality, 3);
        } else {
            quality = 0;
        }
    }

    private void updateNormalGoods() {
        if(sellIn > 0) {
            decreasePrice(quality, 1);
        } else {
            decreasePrice(quality, 2);
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
