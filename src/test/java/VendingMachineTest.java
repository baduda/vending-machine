import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VendingMachineTest {

    private VendingMachine vendingMachine;

    @BeforeEach

    public void setUp() {
        vendingMachine = new VendingMachine(
                new Item[]{
                        new Item(Goods.COCA_COLA, 10),
                        new Item(Goods.COFFEE, 20),
                        new Item(Goods.TEA, 5.5)
                });
    }

    @Test
    public void shouldMakeSimpleOrder() {
        vendingMachine.pressButton(Button.BUTTON_1);
        double totalPrice = vendingMachine.makeOrder();
        Assertions.assertEquals(10, totalPrice);
    }

    @Test
    public void shouldMakeComplexOrder() {
        vendingMachine.pressButton(Button.BUTTON_1);
        vendingMachine.pressButton(Button.BUTTON_2);
        vendingMachine.pressButton(Button.BUTTON_2);
        vendingMachine.pressButton(Button.BUTTON_3);
        double totalPrice = vendingMachine.makeOrder();
        Assertions.assertEquals(55.5, totalPrice);
    }

    @Test
    public void shouldReturnOrderedGoods() {
        vendingMachine.pressButton(Button.BUTTON_1);
        vendingMachine.pressButton(Button.BUTTON_2);
        vendingMachine.pressButton(Button.BUTTON_2);
        vendingMachine.pressButton(Button.BUTTON_3);
        vendingMachine.pressButton(Button.BUTTON_3);

        Goods[] orderedGoods = vendingMachine.getOrderedGoods();
        Assertions.assertArrayEquals(
                new Goods[]{Goods.COCA_COLA, Goods.COFFEE, Goods.COFFEE, Goods.TEA, Goods.TEA},
                orderedGoods);
    }

    @Test
    public void shouldMakeTwoOrders() {
        vendingMachine.pressButton(Button.BUTTON_1);
        double totalPrice1 = vendingMachine.makeOrder();
        Assertions.assertEquals(10, totalPrice1);

        vendingMachine.pressButton(Button.BUTTON_2);
        double totalPrice2 = vendingMachine.makeOrder();
        Assertions.assertEquals(20, totalPrice2);
    }

}
