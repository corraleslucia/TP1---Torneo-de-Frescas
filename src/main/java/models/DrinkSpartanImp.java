package models;

import interfaces.IDrink;

public class DrinkSpartanImp implements IDrink {

    //Returns a random number between 0.5 to 1.5
    @Override
    public Double drink() {
        return (Math.random() * ((1.5 - 0.5) + 1)) + 0.5;
    }
}
