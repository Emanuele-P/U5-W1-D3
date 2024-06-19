package ep2024.u5w1d3.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Pizza {
    private String name;
    private double price;
    private int calories;
    private List<String> toppings;

    public Pizza(String name, double price, int calories) {
        this.name = name;
        this.price = price;
        this.calories = calories;
        this.toppings = new ArrayList<>();
        this.toppings.add("Mozzarella");
        this.toppings.add("Tomato");
    }

    public void addTopping(String topping) {
        toppings.add(topping);
    }

    @Override
    public String toString() {
        return "Pizza: " + name + " (" + toppings + ") " + price + "€" + " --- " + calories + " Kcal";
    }
}