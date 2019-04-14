package models;

import interfaces.IDrink;
import interfaces.IPee;

public class TabernOwer extends Human {
    private final Double proDrinker = 1.5;
    private final Integer extraTolerance = 1;

    public TabernOwer(String name, Integer age, Integer weight, IDrink iDrink, IPee iPee) {
        super(name, age, weight, iDrink, iPee);
    }

    @Override
    public Double compete() {
        Double result = 0.0;
        Integer peeProb = (((getWeight() * 2) - getAge()) / 31) + getiPee().pee() - extraTolerance;
        if (peeProb < 6) { //if the probability of peeing is under 6
            result = getiDrink().drink();
        }
        return getiDrink().drink() * proDrinker;
    }
}
