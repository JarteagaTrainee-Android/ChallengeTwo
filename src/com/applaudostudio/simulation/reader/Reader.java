package com.applaudostudio.simulation.reader;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

class Reader {
    private String mFileName;

    public Reader(String mFileName) {
        this.mFileName = mFileName;
    }

    public String getmFileName() {
        return mFileName;
    }

    public void setmFileName(String mFileName) {
        this.mFileName = mFileName;
    }

   /***
    * Return the whole file of movies
    * @return the complete file
    */
   private File getFileContent() {
       return new File(this.getmFileName());
   }

   /***
    * Function to get the movies as a List
    * @throws Exception for files
    */
   ArrayList<String> getMoviesList() throws  Exception{
       ArrayList<String> movieList = new ArrayList<>();
       Scanner scanner = new Scanner(getFileContent());
       while(scanner.hasNextLine()){
           movieList.add(scanner.nextLine());
       }
       return movieList;
   }




}
