package org.model;

public class Simpsons {
    private int age;
    private String genre;
    private String height;
    private double weight;
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

    public int getAge() {
        return age;
    }

    public String getGenre() {
        return genre;
    }

    public String getHeight() {
        return height;
    }

    public String getTopClothesColor() {
        return topClothesColor;
    }
    public String getHairColor() {
        return hairColor;
    }

    public double getWeight() {
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
