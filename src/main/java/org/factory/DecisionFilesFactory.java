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


        try {
            BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(trainingDatasetFilename));
            writer.write(trainingDataset.toString());
            writer.flush();
            writer.close();
        } catch (Exception e){
            System.out.println("Failed to save dataset: " + e);
        }


    }
}
