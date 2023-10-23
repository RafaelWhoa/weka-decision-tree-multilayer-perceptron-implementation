package org.main;

import weka.attributeSelection.ASEvaluation;
import weka.attributeSelection.AttributeEvaluator;
import weka.attributeSelection.ClassifierAttributeEval;
import weka.attributeSelection.GainRatioAttributeEval;
import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.classifiers.functions.MultilayerPerceptron;
import weka.classifiers.trees.J48;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;

import java.nio.file.Path;

public class DecisionTree {

    public static void process(String trainingDatasetFilename, String testingDatasetFilename) throws Exception {

        ConverterUtils.DataSource traningSource = new ConverterUtils.DataSource(Path.of(trainingDatasetFilename).toUri().toString());
        ConverterUtils.DataSource testingSource = new ConverterUtils.DataSource(Path.of(testingDatasetFilename).toUri().toString());

        Instances trainingDataSet = traningSource.getDataSet();
        Instances testingDataSet = testingSource.getDataSet();

        trainingDataSet.setClassIndex(trainingDataSet.numAttributes() - 1);
        testingDataSet.setClassIndex(testingDataSet.numAttributes() - 1);

        System.out.println("************************** J48 *************************");
        /** Classifier here is Linear Regression */
        Classifier classifier = new J48();
        Classifier mpClassifier = new MultilayerPerceptron();

        //J48,MultilayerPerceptron
        /** */
        classifier.buildClassifier(trainingDataSet);
        mpClassifier.buildClassifier(testingDataSet);
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

        Evaluation mpEval = new Evaluation(trainingDataSet);
        mpEval.evaluateModel(mpClassifier, testingDataSet);
        /** Print the algorithm summary */
        System.out.println("** Decision Tress Evaluation with Datasets **");
        System.out.println(mpEval.toSummaryString());
        System.out.println(mpEval.SFSchemeEntropy());
        System.out.print(" the expression for the input data as per alogorithm is ");
        System.out.println(mpClassifier);
        System.out.println(mpEval.toMatrixString());
        System.out.println(mpEval.toClassDetailsString());
    }
}
