package models;

import interfaces.IPee;

import static java.lang.Math.random;

public class PeeVikingImp implements IPee {

    //Returns a number between 0 and 8
    @Override
    public Integer pee() {
        return (int) (random() * 8);
    }
}
