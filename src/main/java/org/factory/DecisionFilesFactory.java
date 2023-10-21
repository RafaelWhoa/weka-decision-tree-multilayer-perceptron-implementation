package org.factory;

import weka.core.Attribute;
import weka.core.Instances;
import weka.core.converters.ArffSaver;
import weka.core.converters.ConverterUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;
import java.util.jar.Attributes;

public class DecisionFilesFactory {
    public static void createDecisionFiles(String trainingDatasetFilename, String testingDatasetFilename) {
        ArrayList<Attribute> atts;
        ArrayList<Attribute> attsRel;
        ArrayList<String> genres;
        ArrayList<String> heights;
        ArrayList<String> simpsons;
        ArrayList<String> attValsRel;
        Instances trainingDataset;
        Instances testingDataset;
        Instances dataRel;
        double[] trainingVals;
        double[] testingVals;
        double[] valsRel;
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
        simpsons = new ArrayList<String>();
        simpsons.add("Short");
        simpsons.add("Big");
        atts.add(new Attribute("whichSimpson", simpsons));

        trainingDataset = new Instances("TrainingSimpsonsRelation", atts, 0);
        testingDataset = new Instances("TestingSimpsonsRelation", atts, 0);

        if(!Files.exists(Path.of(trainingDatasetFilename))){
            for (int i = 1; i <= 500; i++){
                trainingVals = new double[trainingDataset.numAttributes()];
                trainingVals[0] = new Random().nextInt(0, 97);
                trainingVals[1] = genres.indexOf(new Random().nextBoolean() ? "M" : "F");
                trainingVals[2] = heights.indexOf(new Random().nextBoolean() ? "Short" : "Big");
                trainingVals[3] = new Random().nextDouble(20, 200);
                trainingVals[4] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
                trainingVals[5] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
                trainingVals[6] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
                trainingVals[7] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
                trainingDataset.add(new weka.core.DenseInstance(1.0, trainingVals));
            }
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(trainingDatasetFilename));
                writer.write(trainingDataset.toString());
                writer.flush();
                writer.close();
            } catch (Exception e){
                System.out.println("Failed to save dataset: " + e);
            }
        }

        if(!Files.exists(Path.of(testingDatasetFilename))){
            for (int i = 1; i <= 100; i++){
                testingVals = new double[testingDataset.numAttributes()];
                testingVals[0] = new Random().nextInt(0, 97);
                testingVals[1] = genres.indexOf(new Random().nextBoolean() ? "M" : "F");
                testingVals[2] = heights.indexOf(new Random().nextBoolean() ? "Short" : "Big");
                testingVals[3] = new Random().nextDouble(20, 200);
                testingVals[4] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
                testingVals[5] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
                testingVals[6] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
                testingVals[7] = colors.indexOf(colors.get(new Random().nextInt(0, 7)));
                testingDataset.add(new weka.core.DenseInstance(1.0, testingVals));
            }
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(testingDatasetFilename));
                writer.write(testingDataset.toString());
                writer.flush();
                writer.close();
            } catch (Exception e){
                System.out.println("Failed to save dataset: " + e);
            }
        }


    }
}
