import java.util.ArrayList;

public class VendingMachine {

    private final Item[] items;
    private double totalPrice = 0;
    private ArrayList<Goods> orderedGoods = new ArrayList<>();

    public VendingMachine(Item[] items) {
        this.items = items;
    }

    public void pressButton(Button button) {
        Item item = switch (button) {
            case BUTTON_1 -> items[0];
            case BUTTON_2 -> items[1];
            case BUTTON_3 -> items[2];
            case BUTTON_4 -> items[3];
            case BUTTON_5 -> items[4];
        };
        totalPrice += item.getPrice();
        orderedGoods.add(item.getGoods());
    }

    public Goods[] getOrderedGoods() {
        return orderedGoods.toArray(new Goods[]{});
    }

    public double makeOrder() {
        double r = totalPrice;
        totalPrice = 0;
        orderedGoods = new ArrayList<>();
        return r;
    }
}
