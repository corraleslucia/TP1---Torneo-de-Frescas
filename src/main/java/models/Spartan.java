package models;

import interfaces.IDrink;
import interfaces.IPee;

public class Spartan extends Human {
    private final Integer extraTolerance = 1;

    public Spartan(String name, Integer age, Integer weight, IDrink iDrink, IPee iPee) {
        super(name, age, weight, iDrink, iPee);
    }

    //checks the probability of peeing, and returns the consumed quantity.
    public Double compete() {
        Double result = 0.0;
        Integer peeProb = (((getWeight()*2) - getAge()) / 31) + getiPee().pee() - extraTolerance;
        if(peeProb<6){ //if the probability of peeing is under 6
            result = getiDrink().drink();
        }
        return result;
    }
}
