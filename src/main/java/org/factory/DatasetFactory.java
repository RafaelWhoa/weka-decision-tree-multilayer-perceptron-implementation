package org.factory;

import org.model.Dataset;
import weka.core.Attribute;
import weka.core.Instances;

import java.io.BufferedWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Random;

public class DatasetFactory {
    public static void main(String[] args) {

    }
    public static Instances createDataset(String trainingDatasetFilename,
                                        String testingDatasetFilename,
                                        ArrayList<String> colors,
                                        Instances testDataset){

        ArrayList<Attribute> atts;
        Instances testingDataset;
        double[] testingVals;
        ArrayList<String> genres;
        ArrayList<String> heights;
        ArrayList<String> simpsons;

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
        //atts.add(new Attribute("whichSimpson", simpsons));

        testingDataset = new Instances("TestingSimpsonsRelation", atts, 0);

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
        }
        return testingDataset;
    }

    public static Instances create
}
