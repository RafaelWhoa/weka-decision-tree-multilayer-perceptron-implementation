package org.main;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.meta.FilteredClassifier;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ArffLoader;
import weka.core.converters.ConverterUtils;
import weka.gui.beans.DataSource;

import java.io.File;
import java.nio.file.Path;

public class DecisionTree {

//    public static Instances getDataSet(String fileName) {
//        try {
//            int classIdx = 1;
//            ArffLoader loader = new ArffLoader();
//            //loader.setSource(DecisionTree.class.getResourceAsStream("/" + fileName));
//            loader.setFile(new File(fileName));
//            Instances dataSet = loader.getDataSet();
//            dataSet.setClassIndex(classIdx);
//            return dataSet;
//        } catch (Exception e) {
//            System.out.println("Error: " + e);
//            return null;
//        }
//    }

    public static void process(String trainingDatasetFilename, String testingDatasetFilename) throws Exception {
//        Instances trainingDataSet = getDataSet("decision-training.arff");
//        Instances testingDataSet = getDataSet("decision-testing.arff");

        ConverterUtils.DataSource traningSource = new ConverterUtils.DataSource(Path.of(trainingDatasetFilename).toUri().toString());
        ConverterUtils.DataSource testingSource = new ConverterUtils.DataSource(Path.of(testingDatasetFilename).toUri().toString());

        Instances trainingDataSet = traningSource.getDataSet();
        Instances testingDataSet = testingSource.getDataSet();

        trainingDataSet.setClassIndex(trainingDataSet.numAttributes() - 1);
        testingDataSet.setClassIndex(testingDataSet.numAttributes() - 1);

        System.out.println("************************** J48 *************************");
        /** Classifier here is Linear Regression */
        Classifier classifier = new J48();

        //J48,Id3
        /** */
        classifier.buildClassifier(trainingDataSet);
        /**
         * train the alogorithm with the training data and evaluate the
         * algorithm with testing data
         */

        Evaluation eval = new Evaluation(trainingDataSet);
        eval.evaluateModel(classifier, testingDataSet);
        /** Print the algorithm summary */
        System.out.println("** Decision Tress Evaluation with Datasets **");
        System.out.println(eval.toSummaryString());
        System.out.println(eval.SFSchemeEntropy());
        System.out.print(" the expression for the input data as per alogorithm is ");
        System.out.println(classifier);
        System.out.println(eval.toMatrixString());
        System.out.println(eval.toClassDetailsString());
    }
}
