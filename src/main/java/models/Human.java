package models;

import interfaces.IDrink;
import interfaces.IPee;

public abstract class Human {
    private String name;
    private Integer age;
    private Integer weight;
    private IDrink iDrink;
    private IPee iPee;

    public Human(String name, Integer age, Integer weight, IDrink iDrink, IPee iPee) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.iDrink = iDrink;
        this.iPee = iPee;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public IDrink getiDrink() {
        return iDrink;
    }

    public void setiDrink(IDrink iDrink) {
        this.iDrink = iDrink;
    }

    public IPee getiPee() {
        return iPee;
    }

    public void setiPee(IPee iPee) {
        this.iPee = iPee;
    }

    public abstract Double compete();

    @Override
    public String toString() {

        return String.format("Name: %s\nAge: %s\nWeight: %s\n", name, age, weight);
    }
}
