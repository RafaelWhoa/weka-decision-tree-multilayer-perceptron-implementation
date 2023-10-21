package org.factory;

import org.model.Simpsons;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileFactory<T> {
    public static boolean createFile(String filename) {
        try {
            File myObj = new File(filename);
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
                return true;
            } else {
                System.out.println("File already exists.");
                return false;
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
            return false;
        }
    }

    public static void writeSimpsonsToFile(String filename, ArrayList<Simpsons> simpsons) {
        try {
            FileWriter myWriter = new FileWriter(filename);
            for (Simpsons simpson : simpsons) {
                myWriter.write(simpsons.indexOf(simpson) + 1 + ". " + simpson.toString() + "\n");
            }
            myWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readSimpsonsFromFile(String filename){
        try {
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                System.out.print(data + "\n");
            }
            myReader.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
