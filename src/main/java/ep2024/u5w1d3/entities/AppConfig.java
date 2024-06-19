package ep2024.u5w1d3.entities;

import ep2024.u5w1d3.enums.ReservationStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;

import java.util.ArrayList;
import java.util.List;

@Configuration
@PropertySource("application.properties")
public class AppConfig {

    @Bean
    @Primary
    public Pizza getMargherita() {
        return new Pizza("Margherita", 8, 700);
    }

    @Bean
    public Pizza getHawaiian() {
        Pizza hawaiian = new Pizza("Hawaiian", 10, 924);
        hawaiian.addTopping("Ham");
        hawaiian.addTopping("Pineapple");
        return hawaiian;
    }

    @Bean
    public Pizza getSalami() {
        Pizza salami = new Pizza("Salami", 9, 1160);
        salami.addTopping("Salami");
        return salami;
    }

    @Bean
    public Pizza getPepperoni() {
        Pizza pepperoni = new Pizza("Pepperoni", 9.5, 1100);
        pepperoni.addTopping("Pepperoni");
        return pepperoni;
    }

    @Bean
    public Pizza getVegetarian() {
        Pizza vegetarian = new Pizza("Vegetarian", 8.5, 900);
        vegetarian.addTopping("Bell Peppers");
        vegetarian.addTopping("Onions");
        vegetarian.addTopping("Olives");
        return vegetarian;
    }

    @Bean
    public Pizza getFourCheese() {
        Pizza fourCheese = new Pizza("Four Cheese", 11, 1250);
        fourCheese.addTopping("Parmesan");
        fourCheese.addTopping("Gorgonzola");
        fourCheese.addTopping("Ricotta");
        return fourCheese;
    }

    @Bean
    public Drink getCola() {
        return new Drink("Cola", 2, 150);
    }

    @Bean
    public Drink getWater() {
        return new Drink("Water", 1.50, 0);
    }

    @Bean
    public Drink getLemonade() {
        return new Drink("Lemonade", 2.50, 120);
    }

    @Bean
    public Drink getWine() {
        return new Drink("Wine", 9, 607);
    }

    @Bean
    public Topping getHam() {
        return new Topping("Ham", 1, 120);
    }

    @Bean
    public Topping getSalamiTopping() {
        return new Topping("Salami", 1.5, 130);
    }

    @Bean
    public Topping getPineapple() {
        return new Topping("Pineapple", 2, 80);
    }

    @Bean
    public Topping getMozzarella() {
        return new Topping("Mozzarella", 1, 90);
    }

    @Bean
    public Topping getOnions() {
        return new Topping("Onions", 0.5, 20);
    }

    @Bean("pizzas")
    List<Pizza> pizzaList() {
        List<Pizza> pizzas = new ArrayList<>();
        pizzas.add(getMargherita());
        pizzas.add(getHawaiian());
        pizzas.add(getFourCheese());
        pizzas.add(getSalami());
        pizzas.add(getPepperoni());
        pizzas.add(getVegetarian());
        return pizzas;
    }

    @Bean("toppings")
    List<Topping> toppingList() {
        List<Topping> toppings = new ArrayList<>();
        toppings.add(getHam());
        toppings.add(getSalamiTopping());
        toppings.add(getPineapple());
        toppings.add(getOnions());
        toppings.add(getMozzarella());
        return toppings;
    }

    @Bean("drinks")
    List<Drink> drinkList() {
        List<Drink> drinks = new ArrayList<>();
        drinks.add(getWater());
        drinks.add(getWine());
        drinks.add(getCola());
        drinks.add(getLemonade());
        return drinks;
    }

    @Bean
    public Menu menu() {
        return new Menu(pizzaList(), toppingList(), drinkList());
    }

    @Bean("table_one")
    Table getTable1(@Value("${seat.price}") double seatPrice) {
        return new Table(1, 6, ReservationStatus.FREE, seatPrice);
    }

    @Bean("table_two")
    Table getTable2(@Value("${seat.price}") double seatPrice) {
        return new Table(7, 2, ReservationStatus.RESERVED, seatPrice);
    }

    @Bean("table_three")
    Table getTable3(@Value("${seat.price}") double seatPrice) {
        return new Table(4, 4, ReservationStatus.FREE, seatPrice);
    }

    @Bean("table_four")
    Table getTable4(@Value("${seat.price}") double seatPrice) {
        return new Table(10, 8, ReservationStatus.RESERVED, seatPrice);
    }
}
