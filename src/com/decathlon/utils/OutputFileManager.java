package com.decathlon.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFileManager {

   public static void createXMLFile(String htmlString, String outputFile){
       File outputHTML = new File(outputFile);
       BufferedWriter bufferedWriter;
       try {
           bufferedWriter = new BufferedWriter(new FileWriter(outputHTML));
           bufferedWriter.write(htmlString);
           bufferedWriter.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}
