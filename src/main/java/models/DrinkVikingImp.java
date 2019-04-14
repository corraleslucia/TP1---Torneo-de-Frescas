package models;

import interfaces.IDrink;

public class DrinkVikingImp implements IDrink {

    //Returns a random number between 1 to 2
    @Override
    public Double drink() {
        return (Math.random() * ((2 - 1) + 1)) + 1;
    }
}
