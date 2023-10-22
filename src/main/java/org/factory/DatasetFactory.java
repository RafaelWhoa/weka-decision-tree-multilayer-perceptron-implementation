package org.factory;

import org.model.Simpsons;
import org.model.SimpsonsTraining;
import weka.core.Attribute;
import weka.core.Instances;

import java.util.ArrayList;
import java.util.Random;

public class DatasetFactory {
    public static void main(String[] args) {

    }

    public static Instances createDataset(String testingDatasetFilename,
                                          ArrayList<String> colors,
                                          ArrayList<SimpsonsTraining> simpsonsForTesting) {

        ArrayList<Attribute> atts;
        Instances testingDataset;
        double[] testingVals;
        ArrayList<String> genres;
        ArrayList<String> heights;
        ArrayList<String> simpsonsList = new ArrayList<>();

        atts = new ArrayList<Attribute>();
        atts.add(new Attribute("age"));
        genres = new ArrayList<String>();
        genres.add("M");
        genres.add("F");
        atts.add(new Attribute("genre", genres));
        heights = new ArrayList<String>();
        heights.add("Short");
        heights.add("Big");
        atts.add(new Attribute("height", heights));
        atts.add(new Attribute("weight"));
        atts.add(new Attribute("topClothesColor", colors));
        atts.add(new Attribute("bottomClothesColor", colors));
        atts.add(new Attribute("shoesColor", colors));
        atts.add(new Attribute("hairColor", colors));
        simpsonsList.add("Bart");
        simpsonsList.add("Lisa");
        simpsonsList.add("Homer");
        atts.add(new Attribute("whichSimpson", simpsonsList));

        testingDataset = new Instances("TestingSimpsonsRelation", atts, 0);

        for (Simpsons simpsons : simpsonsForTesting
        ) {
            testingVals = new double[testingDataset.numAttributes()];
            testingVals[0] = simpsons.getAge();
            testingVals[1] = genres.indexOf(simpsons.getGenre());
            testingVals[2] = heights.indexOf(simpsons.getHeight());
            testingVals[3] = simpsons.getWeight();
            testingVals[4] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
            testingVals[5] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
            testingVals[6] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
            testingVals[7] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
            testingVals[8] = simpsonsList.indexOf(simpsons.getWhichSimpsons());
            testingDataset.add(new weka.core.DenseInstance(1.0, testingVals));
        }
        testingDataset.setClassIndex(testingDataset.numAttributes() - 1);
        return testingDataset;
    }

    public static Instances createTrainingDataset(String testingDatasetFilename,
                                                  ArrayList<String> colors,
                                                  ArrayList<SimpsonsTraining> simpsonsForTraining) {

        ArrayList<Attribute> atts;
        Instances trainingDataset;
        double[] trainingVals;
        ArrayList<String> genres;
        ArrayList<String> heights;
        ArrayList<String> simpsonsList = new ArrayList<>();

        atts = new ArrayList<Attribute>();
        atts.add(new Attribute("age"));
        genres = new ArrayList<String>();
        genres.add("M");
        genres.add("F");
        atts.add(new Attribute("genre", genres));
        heights = new ArrayList<String>();
        heights.add("Short");
        heights.add("Big");
        atts.add(new Attribute("height", heights));
        atts.add(new Attribute("weight"));
        atts.add(new Attribute("topClothesColor", colors));
        atts.add(new Attribute("bottomClothesColor", colors));
        atts.add(new Attribute("shoesColor", colors));
        atts.add(new Attribute("hairColor", colors));
        simpsonsList.add("Bart");
        simpsonsList.add("Lisa");
        simpsonsList.add("Homer");
        atts.add(new Attribute("whichSimpson", simpsonsList));

        trainingDataset = new Instances("TestingSimpsonsRelation", atts, 0);

        for (SimpsonsTraining simpsons : simpsonsForTraining
        ) {
            trainingVals = new double[trainingDataset.numAttributes()];
            trainingVals[0] = simpsons.getAge();
            trainingVals[1] = genres.indexOf(simpsons.getGenre());
            trainingVals[2] = heights.indexOf(simpsons.getHeight());
            trainingVals[3] = simpsons.getWeight();
            trainingVals[4] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
            trainingVals[5] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
            trainingVals[6] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
            trainingVals[7] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
            trainingVals[8] = simpsonsList.indexOf(simpsons.getWhichSimpsons());
            trainingDataset.add(new weka.core.DenseInstance(1.0, trainingVals));
        }
        trainingDataset.setClassIndex(trainingDataset.numAttributes() - 1);
        return trainingDataset;
    }
}
