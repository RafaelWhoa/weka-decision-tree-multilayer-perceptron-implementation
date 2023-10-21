package org.factory;

import org.model.Simpsons;

public class SimpsonsFactory<T> {
    public static Simpsons createSimpsons(int age, String genre, String height, double weight, String topClothesColor, String bottomClothesColor, String shoesColor, String hairColor){
        return new Simpsons(age, genre, height, weight, topClothesColor, bottomClothesColor, shoesColor, hairColor);
    };
}
