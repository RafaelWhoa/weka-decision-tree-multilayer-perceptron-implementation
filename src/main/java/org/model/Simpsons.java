package org.model;

public class Simpsons {
    private static int age;
    private static String genre;
    private static String height;
    private static double weight;
    private String topClothesColor;
    private String bottomClothesColor;
    private String shoesColor;
    private String hairColor;

    public Simpsons(int age, String genre, String height, double weight, String topClothesColor, String bottomClothesColor, String shoesColor, String hairColor) {
        this.age = age;
        this.genre = genre;
        this.height = height;
        this.weight = weight;
        this.topClothesColor = topClothesColor;
        this.bottomClothesColor = bottomClothesColor;
        this.shoesColor = shoesColor;
        this.hairColor = hairColor;
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

    public String getTopClothesColor() {
        return topClothesColor;
    }
    public String getHairColor() {
        return hairColor;
    }

    public static double getWeight() {
        return weight;
    }

    public String getBottomClothesColor() {
        return bottomClothesColor;
    }

    public String getShoesColor() {
        return shoesColor;
    }

    @Override
    public String toString() {
        return "Simpsons{" +
                "age=" + age +
                ", genre='" + genre + '\'' +
                ", height='" + height + '\'' +
                ", weight=" + String.format("%.2f", weight) +
                ", topClothesColor='" + topClothesColor + '\'' +
                ", bottomClothesColor='" + bottomClothesColor + '\'' +
                ", shoesColor='" + shoesColor + '\'' +
                ", hairColor='" + hairColor + '\'' +
                '}';
    }
}
