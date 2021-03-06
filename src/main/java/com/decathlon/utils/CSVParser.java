package com.decathlon.utils;

import com.decathlon.domain.Athlete;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  Utility class used to parse csv file and
 *  create List<Athlete>. CSV file values must
 *  be separated by a semicolon. In case when values are separated
 *  by some other punctuation mark, alter @parseCSV method accordingly.
 *  Each line of CSV file must correspond to separate athlete's data. First
 *  value on each line is athletes name, followed by 10 decathlon results.
 */


public class CSVParser {

    /**
     * This method takes CSV file as an argument and reads it line by line, each
     * line should correspond to separate athlete's data, results will be parsed into
     * two-dimensional ArrayList.
     *
     * Throws IOException if file is not found.
     *
     * @param inputFile [File] CSV file
     *
     * @return [List<List<String>>] Two-dimensional arraylist, where every
     *                              List<String> holds individual athletes' data.
     */
    public static List<List<String>> parseCSV(File inputFile)  {
        List<List<String>> athleteCSVData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isEmpty())
                    continue;
                String[] values = line.split(";");
                athleteCSVData.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return athleteCSVData;
    }

    /**
     * This method is used to create an ArrayList of Athlete objects.
     * It takes a two-dimensional ArrayList as a parameter, where
     * each nested arraylist must correspond to unique athlete's data.
     *
     * @param athletesCSVData [List<List<String>>] Where ach nested
     *                        ArrayList hold separate athlete's data.
     *
     *
     * @return [List<Athlete>] Arraylist of Athlete type objects.
     */
    public static List<Athlete> getAthleteList(List<List<String>> athletesCSVData){
        List<Athlete> athleteList = new ArrayList<>();
        for (List<String> AthleteData : athletesCSVData){
            String athleteName = AthleteData.get(0);
            String[] athleteResults = (AthleteData.subList(1, AthleteData.size()))
                    .toArray(new String[0]);
            athleteList.add(new Athlete(athleteName, athleteResults));
        }
        return athleteList;
    }

}
