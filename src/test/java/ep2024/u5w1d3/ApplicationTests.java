package ep2024.u5w1d3;

import ep2024.u5w1d3.entities.*;
import ep2024.u5w1d3.enums.OrderStatus;
import ep2024.u5w1d3.enums.ReservationStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationTests {

    @Test
    void testGetters() {
        System.out.println("testing drink getters...");
        Drink drink = new Drink("Sparkly water", 2, 0);
        assertEquals("Sparkly water", drink.getName());
        assertEquals(2, drink.getPrice());
        assertEquals(0, drink.getCalories());
    }

    @Test
    void testAddTopping() {
        System.out.println("testing addTopping method...");
        Pizza pizza = new Pizza("Margherita", 8, 700);
        pizza.addTopping("Basil");
        assertTrue(pizza.getToppings().contains("Basil"));
    }

    @Test
    void testCalculateTotal() {
        System.out.println("testing calculateTotal method...");

        Pizza pizza = new Pizza("Margherita", 8, 700);
        Drink drink = new Drink("Cola", 2, 150);
        Topping topping = new Topping("Basil", 0.50, 10);
        Table table = new Table(1, 2, ReservationStatus.RESERVED, 2.0);
        Order order = new Order(OrderStatus.READY, 2, table);

        order.addPizza(pizza);
        order.addDrink(drink);
        order.addTopping(topping);

        order.calculateTotal(table.getCoverCharge());
        assertEquals(14.50, order.getTotal());
    }

    @ParameterizedTest
    @CsvSource({"8", "10", "9.5", "11"})
    void testPrices(double price) {
        System.out.println("testing prices...");
        Pizza pizza = new Pizza("TestPizza", price, 700);
        assertEquals(price, pizza.getPrice());
    }

    @ParameterizedTest
    @CsvSource({"150", "120", "0"})
    void testCalories(int calories) {
        System.out.println("testing calories...");
        Drink drink = new Drink("TestDrink", 2, calories);
        assertEquals(calories, drink.getCalories());
    }

    @Test
    void testMenuPrinting(@Autowired ApplicationContext context) {
        System.out.println("testing printMenu...");
        Menu menu = context.getBean(Menu.class);
        assertNotNull(menu);

        List<Pizza> pizzas = menu.getPizzas();
        assertNotNull(pizzas);
        assertFalse(pizzas.isEmpty());

        List<Drink> drinks = menu.getDrinks();
        assertNotNull(drinks);
        assertFalse(drinks.isEmpty());

        List<Topping> toppings = menu.getToppings();
        assertNotNull(toppings);
        assertFalse(toppings.isEmpty());
    }
}
