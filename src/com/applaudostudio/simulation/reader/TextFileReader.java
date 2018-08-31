package com.applaudostudio.simulation.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class TextFileReader {
    private String mFileName;

    public TextFileReader(String mFileName) {
        this.mFileName = mFileName;
    }

    /***
     * Return the whole file of movies
     * @return the complete file
     */
    private File getFileContent() {
        return new File(this.mFileName);
    }

    /***
     * Function to get the movies as a List
     */
    public ArrayList<String> getItemsText() {
        ArrayList<String> movieList = new ArrayList<>();
        Scanner scanner = null;
        try {
            scanner = new Scanner(getFileContent());
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }

        assert scanner != null;
        while (scanner.hasNextLine()) {
            movieList.add(scanner.nextLine());
        }
        return movieList;
    }


}
