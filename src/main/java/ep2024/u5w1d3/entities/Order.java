package ep2024.u5w1d3.entities;

import ep2024.u5w1d3.enums.OrderStatus;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Order {
    private int number;
    private OrderStatus status;
    private int covers;
    private LocalTime time;
    private List<Pizza> pizzas;
    private List<Topping> toppings;
    private List<Drink> drinks;
    private Table table;
    private double total;


    public Order(OrderStatus status, int covers, Table table) {
        Random random = new Random();
        this.number = random.nextInt(1000, 9999);
        this.status = status;
        if (table.getCovers() <= covers) {
            throw new RuntimeException("The number of covers is higher than the table's max seats number.");
        }
        this.covers = covers;
        this.time = LocalTime.now();
        this.pizzas = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.table = table;
        this.total = 0;
    }

    public void addPizza(Pizza pizza) {
        pizzas.add(pizza);
        total += pizza.getPrice();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
        total += topping.getPrice();
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
        total += drink.getPrice();
    }

    public void calculateTotal(double coverCharge) {
        total += covers * coverCharge;
    }

    public void printOrder() {
        System.out.println("Order {" +
                "\nnumber = " + number +
                ", status = " + status +
                ", covers = " + covers +
                ", time = " + time +
                ", \npizzas = " + pizzas +
                ", \ntoppings = " + toppings +
                ", \ndrinks = " + drinks +
                ", \ntable=" + table +
                ", total = " + total +
                '}');
    }
}


