package org.factory;

import org.model.SimpsonsTraining;
import weka.core.Instances;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class DecisionFilesFactory {
    public static void createDecisionFiles(String trainingDatasetFilename,
                                           String testingDatasetFilename,
                                           ArrayList<String> colors,
                                           ArrayList<SimpsonsTraining> simpsonsForTraining,
                                           ArrayList<SimpsonsTraining> simpsonsForTesting) throws IOException {

        Instances trainingDataset = DatasetFactory.createTrainingDataset(trainingDatasetFilename, colors, simpsonsForTraining);
        Instances testingDataset = DatasetFactory.createDataset(testingDatasetFilename, colors, simpsonsForTesting);

        if(!Files.exists(Path.of(trainingDatasetFilename))) {
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(trainingDatasetFilename));
                writer.write(trainingDataset.toString());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                System.out.println("Failed to save training dataset: " + e);
            }
        }

        if(!Files.exists(Path.of(testingDatasetFilename))) {
            try {
                BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(testingDatasetFilename));
                writer.write(testingDataset.toString());
                writer.flush();
                writer.close();
            } catch (Exception e) {
                System.out.println("Failed to save testing dataset: " + e);
            }
        }

    }
}
