package ep2024.u5w1d3.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Topping {
    private String name;
    private double price;
    private int calories;

    @Override
    public String toString() {
        return name + " (" + calories + " Kcal, " + price + "€)";
    }
}
