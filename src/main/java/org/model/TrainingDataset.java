package org.model;

public class TrainingDataset extends Dataset {

    private String whichSimpsons;

    public TrainingDataset(int age, String genre, String height, double weight, String topClothesColor, String bottomClothesColor, String shoesColor, String hairColor) {
        super(age, genre, height, weight, topClothesColor, bottomClothesColor, shoesColor, hairColor);
    }

    public String getWhichSimpsons() {
        return whichSimpsons;
    }
}
