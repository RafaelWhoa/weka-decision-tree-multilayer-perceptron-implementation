package org.main;

import org.factory.DecisionFilesFactory;
import org.factory.SimpsonsFactory;
import org.model.SimpsonsTraining;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception {
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

        ArrayList<SimpsonsTraining> simpsonsForTraining = SimpsonsFactory.createSimpsonsForTraining(colors);
        ArrayList<SimpsonsTraining> simpsonsForTesting = SimpsonsFactory.createSimpsonsForTesting(colors);

        DecisionFilesFactory.createDecisionFiles(trainingDatasetFilename, testingDatasetFilename, colors, simpsonsForTraining, simpsonsForTesting);

        DecisionTree.process(trainingDatasetFilename, testingDatasetFilename);
    }
}