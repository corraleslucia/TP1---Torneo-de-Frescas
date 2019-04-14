package models;

import interfaces.IPee;

import static java.lang.Math.random;

public class PeeSpartanImp implements IPee {

    //Returns a number between 0 and 7
    @Override
    public Integer pee() {
        return (int) (random() * 7);
    }
}
