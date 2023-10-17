package vlrtstat.gg.item.domain;

public class ItemGold {
    private int base;
    private boolean purchasable;
    private int total;
    private int sell;

    public ItemGold() {
    }

    public ItemGold(int base, boolean purchasable, int total, int sell) {
        this.base = base;
        this.purchasable = purchasable;
        this.total = total;
        this.sell = sell;
    }

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public boolean isPurchasable() {
        return purchasable;
    }

    public void setPurchasable(boolean purchasable) {
        this.purchasable = purchasable;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSell() {
        return sell;
    }

    public void setSell(int sell) {
        this.sell = sell;
    }
}
