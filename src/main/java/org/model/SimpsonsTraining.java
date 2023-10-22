package org.model;

public class SimpsonsTraining extends Simpsons{

    private String whichSimpsons;

    public SimpsonsTraining(int age, String genre, String height, double weight, String topClothesColor, String bottomClothesColor, String shoesColor, String hairColor, String whichSimpsons) {
        super(age, genre, height, weight, topClothesColor, bottomClothesColor, shoesColor, hairColor);
        this.whichSimpsons = whichSimpsons;
    }

    public String getWhichSimpsons() {
        return whichSimpsons;
    }
}
