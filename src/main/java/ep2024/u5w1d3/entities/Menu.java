package ep2024.u5w1d3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@Component
public class Menu {
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;

    public void printMenu() {
        System.out.println(System.lineSeparator() + "---------------------------------------------MENU-----------------------------------------------");
        System.out.println("------------------PIZZAS------------------------------------------------------------------------");
        for (Pizza pizza : pizzas) {
            System.out.println(pizza);
        }
        System.out.println(System.lineSeparator() + "------------------TOPPINGS----------------------------------------------------------------------");
        for (Topping topping : toppings) {
            System.out.println(topping);
        }
        System.out.println(System.lineSeparator() + "------------------DRINKS------------------------------------------------------------------------");
        for (Drink drink : drinks) {
            System.out.println(drink);
        }
    }
}
