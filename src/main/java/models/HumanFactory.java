package models;

import interfaces.IDrink;
import interfaces.IPee;

public class HumanFactory {
    public static <T extends Human> T getHuman(Class<T> type, String name, Integer age, Integer weight, IDrink iDrink, IPee iPee) {
        if (type == Viking.class) {
            return (T) new Viking(name, age, weight, iDrink, iPee);
        } else if (type == Spartan.class) {
            return (T) new Spartan(name, age, weight, iDrink, iPee);
        } else if (type == TabernOwer.class) {
            return (T) new TabernOwer(name, age, weight, iDrink, iPee);
        }
        return null;
    }
}
