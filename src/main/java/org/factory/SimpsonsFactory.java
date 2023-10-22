package org.factory;

import org.model.Bart;
import org.model.Simpsons;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class SimpsonsFactory<T> {

    public static ArrayList<Object> createSimpsonsForTraining(ArrayList<String> colors) {
        ArrayList<Object> simpsons = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            int j = new Random().nextInt(1, 3);
            if (j == 1) {
                simpsons.add(new Bart(Bart.getAge(),
                        Bart.getGenre(),
                        Bart.getHeight(),
                        Bart.getWeight(),
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        Bart.getWhichSimpsons()));
            } else if (j == 2) {

            } else if (j == 3) {
                // Lisa
            }
        }
        return null;
    }
}
