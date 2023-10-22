package org.factory;

import org.model.Simpsons;
import org.model.SimpsonsTraining;

import java.util.ArrayList;
import java.util.Random;

public class SimpsonsFactory<T> {

    public static ArrayList<SimpsonsTraining> createSimpsonsForTraining(ArrayList<String> colors) {
        ArrayList<SimpsonsTraining> simpsons = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            int j = new Random().nextInt(1, 3);
            if (j == 1) {
                simpsons.add(new SimpsonsTraining(10,
                        "M",
                        "Short",
                        40.0,
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        "Bart"));
            } else if (j == 2) {
                simpsons.add(new SimpsonsTraining(39,
                        "M",
                        "Big",
                        113.0,
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        "Homer"));
            } else if (j == 3) {
                simpsons.add(new SimpsonsTraining(8,
                        "F",
                        "Short",
                        35.0,
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        colors.get(new Random().nextInt(0, 7)),
                        "Lisa"));
            }
        }
        return simpsons;
    }

    public static ArrayList<Simpsons> createSimpsonsForTesting(ArrayList<String> colors) {
        ArrayList<Simpsons> simpsons = new ArrayList<>();
        for (int i = 0; i < 100; i++){
            simpsons.add(new Simpsons(new Random().nextInt(0, 97),
                    new Random().nextBoolean() ? "M" : "F",
                    new Random().nextBoolean() ? "Short" : "Big",
                    new Random().nextDouble(20, 150),
                    colors.get(new Random().nextInt(0, 7)),
                    colors.get(new Random().nextInt(0, 7)),
                    colors.get(new Random().nextInt(0, 7)),
                    colors.get(new Random().nextInt(0, 7))));
        }
        return simpsons;
    }
}
