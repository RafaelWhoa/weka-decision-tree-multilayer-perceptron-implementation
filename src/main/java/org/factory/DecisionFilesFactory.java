package org.factory;

import org.model.Simpsons;
import org.model.SimpsonsTraining;
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
    public static void createDecisionFiles(String trainingDatasetFilename,
                                           String testingDatasetFilename,
                                           ArrayList<String> colors,
                                           ArrayList<SimpsonsTraining> simpsonsForTraining,
                                           ArrayList<Simpsons> simpsonsForTesting) throws IOException {

        Instances trainingDataset = DatasetFactory.createTrainingDataset(trainingDatasetFilename, colors, simpsonsForTraining);
        Instances testingDataset = DatasetFactory.createDataset(testingDatasetFilename, colors, simpsonsForTesting);

        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(trainingDatasetFilename));
            writer.write(trainingDataset.toString());
            writer.flush();
            writer.close();
        } catch (Exception e){
            System.out.println("Failed to save training dataset: " + e);
        }

        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(testingDatasetFilename));
            writer.write(testingDataset.toString());
            writer.flush();
            writer.close();
        } catch (Exception e){
            System.out.println("Failed to save testing dataset: " + e);
        }

    }
}
