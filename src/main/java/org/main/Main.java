package org.main;

import org.factory.DecisionFilesFactory;
import org.model.Bart;
import org.model.Homer;
import org.model.Lisa;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
//        ArrayList<Simpsons> randomSimpsons = new ArrayList<>(12);
//        if (FileFactory.createFile(TRAINING_DATA_SET_FILENAME)) {
//            for (int i = 0; i < 12; i++){
//                randomSimpsons.add(SimpsonsFactory.createSimpsons(new Random().nextInt(0, 97),
//                        new Random().nextBoolean() ? "M" : "F",
//                        new Random().nextBoolean() ? "Short" : "Big",
//                        new Random().nextDouble(20, 200),
//                        colors.get(new Random().nextInt(0, 7)),
//                        colors.get(new Random().nextInt(0, 7)),
//                        colors.get(new Random().nextInt(0, 7)),
//                        colors.get(new Random().nextInt(0, 7))));
//            }
//            FileFactory.writeSimpsonsToFile(TRAINING_DATA_SET_FILENAME, randomSimpsons);
//        }
//
//        FileFactory.readSimpsonsFromFile(TRAINING_DATA_SET_FILENAME);
        final String trainingDatasetFilename = "decision-training.arff";
        final String testingDatasetFilename = "decision-testing.arff";

        var colors = new ArrayList<String>();
        colors.add("Red");
        colors.add("Orange");
        colors.add("White");
        colors.add("Blue");
        colors.add("Yellow");
        colors.add("None");
        colors.add("Green");
        colors.add("Pink");
        colors.add("Grey");

        DecisionFilesFactory.createDecisionFiles(trainingDatasetFilename,  testingDatasetFilename);

        DecisionTree.process();

        Bart bart = new Bart(10,
                "M",
                "Short",
                41,
                "Orange",
                "Blue",
                "Blue",
                "Yellow", Bart.getWhichSimpsons());
        Lisa lisa = new Lisa(8,
                "F",
                "Short",
                35,
                "Red",
                "None",
                "Red",
                "Yellow");
        Homer homer = new Homer(39,
                "M",
                "Big",
                113,
                "White",
                "Blue",
                "Grey",
                "None");
    }
}