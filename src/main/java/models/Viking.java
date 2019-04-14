package models;

import interfaces.IDrink;
import interfaces.IPee;

public class Viking extends Human {
    private final Double proDrinker = 1.5;

    public Viking(String name, Integer age, Integer weight, IDrink iDrink, IPee iPee) {
        super(name, age, weight, iDrink, iPee);
    }

    public Double getProDrinker() {
        return proDrinker;
    }

    //checks the probability of peeing, and returns the consumed quantity.
    public Double compete() {
        Double result = 0.0;
        Integer peeProb = (((getWeight()*2) - getAge()) / 31) + getiPee().pee();
        if(peeProb<6){ //if the probability of peeing is under 6
            result = getiDrink().drink() * proDrinker;
        }
        return result;
    }
}
