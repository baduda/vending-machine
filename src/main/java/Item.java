public class Item {
    private final Goods goods;
    private final double price;

    public Item(Goods goods, double price) {
        this.goods = goods;
        this.price = price;
    }

    public Goods getGoods() {
        return goods;
    }

    public double getPrice() {
        return price;
    }
}
