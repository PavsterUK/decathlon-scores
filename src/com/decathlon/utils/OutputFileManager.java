package com.decathlon.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OutputFileManager {

   public static void createXMLFile(String xmlString, String outputFile){
       File outputXML = new File(outputFile);
       BufferedWriter bufferedWriter;
       try {
           bufferedWriter = new BufferedWriter(new FileWriter(outputXML));
           bufferedWriter.write(xmlString);
           bufferedWriter.close();
       } catch (IOException e) {
           e.printStackTrace();
       }
   }

}
