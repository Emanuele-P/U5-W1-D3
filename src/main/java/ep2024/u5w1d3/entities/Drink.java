package ep2024.u5w1d3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Drink {
    private String name;
    private double price;
    private int calories;

    @Override
    public String toString() {
        return "Drink: " + name + ", " + price + "€" + "---" + calories + " Kcal";
    }
}


