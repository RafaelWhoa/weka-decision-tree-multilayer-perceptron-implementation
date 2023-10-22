package org.model;

public class Bart extends Simpsons {

    private static int age = 10;
    private static String genre = "M";
    private static String height = "Short";
    private static double weight = 40.0;
    private static String whichSimpsons = "Bart";
    public Bart(int age, String genre, String height, double weight, String topClothesColor, String bottomClothesColor, String shoesColor, String hairColor, String whichSimpsons) {
        super(10, "M", "Short", 40.0, topClothesColor, bottomClothesColor, shoesColor, hairColor);
    }

    public static int getAge() {
        return age;
    }

    public static String getGenre() {
        return genre;
    }

    public static String getHeight() {
        return height;
    }

    public static double getWeight() {
        return weight;
    }

    public static String getWhichSimpsons() {
        return whichSimpsons;
    }
}