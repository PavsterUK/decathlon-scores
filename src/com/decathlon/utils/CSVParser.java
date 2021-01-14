package com.decathlon.utils;

import com.decathlon.domain.Athlete;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *  The CSVParser class is used to parse csv file and
 *  create Athlete type ArrayList. CSV file values must
 *  be separated by a semicolon. In case when values are separated
 *  by some other punctuation mark, alter @getData method accordingly.
 *  Each new line of the file corresponds to new athlete's data. First
 *  value on each line is athletes name, followed by 10 decathlon results.
 *
 * @Author Pavel Naumovich
 */


public class CSVParser {

    /**
     * This method takes CSV file as an argument and reads it line by line, each
     * line should correspond to separate athlete data, result will be parsed into
     * two-dimensional ArrayList.
     *
     * @param inputFile This is csv file
     *
     * @return two-dimensional ArrayList, holding separate athlete data.
     */
    public static List<List<String>> getData(File inputFile)  {
        List<List<String>> athleteCSVData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
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
     * @param athletesCSVData This has to be two-dimensional ArrayList where
     *                        each nested ArrayList hold separate athlete's
     *                        data.
     *
     *
     * @return Arraylist of Athlete type objects.
     */
    public static List<Athlete> getAthleteList(List<List<String>> athletesCSVData){
        List<Athlete> athleteList = new ArrayList<>();
        for (List<String> singleAthleteData : athletesCSVData){
            String athleteName = singleAthleteData.get(0);
            String[] athleteResults = new String[10];
            for (int i = 1; i < singleAthleteData.size(); i++){
                athleteResults[i - 1] = singleAthleteData.get(i);
            }
            athleteList.add(new Athlete(athleteName, athleteResults));
        }
        return athleteList;
    }
}
