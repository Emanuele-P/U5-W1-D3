package ep2024.u5w1d3;

import ep2024.u5w1d3.entities.*;
import ep2024.u5w1d3.enums.OrderStatus;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class OrdersRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Application.class);
        try {
            Menu menu = (Menu) context.getBean("menu");
            menu.printMenu();

            Table t1 = (Table) context.getBean("table_one");

            Order o1 = new Order(OrderStatus.READY, 4, t1);

            o1.addDrink(context.getBean("getWater", Drink.class));
            o1.addDrink(context.getBean("getWater", Drink.class));
            o1.addDrink(context.getBean("getWine", Drink.class));
            o1.addPizza(context.getBean("getMargherita", Pizza.class));
            o1.addPizza(context.getBean("getSalami", Pizza.class));
            o1.addPizza(context.getBean("getVegetarian", Pizza.class));
            o1.addPizza(context.getBean("getPepperoni", Pizza.class));
            o1.addTopping(context.getBean("getHam", Topping.class));
            o1.addTopping(context.getBean("getMozzarella", Topping.class));

            System.out.println(System.lineSeparator() + "------------------TABLE 1:----------------------------------------------------------------------");
            o1.printOrder();

            System.out.println("------------------TOTAL-------------------------------------------------------------------------");
            System.out.println(o1.getTotal());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            context.close();
        }
    }
}
