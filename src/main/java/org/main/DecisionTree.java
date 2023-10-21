package org.main;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.trees.J48;
import weka.core.Debug;
import weka.core.Instances;
import weka.core.converters.ArffLoader;

import java.io.File;
import java.util.logging.Logger;

public class DecisionTree {

    public static Instances getDataSet(String fileName) {
        try {
            int classIdx = 1;
            ArffLoader loader = new ArffLoader();
            //loader.setSource(DecisionTree.class.getResourceAsStream("/" + fileName));
            loader.setFile(new File(fileName));
            Instances dataSet = loader.getDataSet();
            dataSet.setClassIndex(classIdx);
            return dataSet;
        } catch (Exception e) {
            System.out.println("Error: " + e);
            return null;
        }
    }

    public static void process() throws Exception {
        Instances trainingDataSet = getDataSet("decision-training.arff");
        Instances testingDataSet = getDataSet("decision-testing.arff");

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
        System.out.print(" the expression for the input data as per alogorithm is ");
        System.out.println(classifier);
        System.out.println(eval.toMatrixString());
        System.out.println(eval.toClassDetailsString());
    }
}
