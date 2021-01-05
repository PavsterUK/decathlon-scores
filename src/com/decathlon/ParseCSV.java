package com.decathlon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ParseCSV {

    //Read file and save data line by line into List<List<String>>
    public static List<List<String>> getData(File inputFile)  {
        List<List<String>> athletesCSVData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                athletesCSVData.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return athletesCSVData;
    }

    //Process List<List<String>> into List<Athlete>
    public static List<Athlete> getAthletesList(List<List<String>> athletesCSVData){
        List<Athlete> athleteList = new ArrayList<>();
        for (List<String> singleAthleteData : athletesCSVData){
            String athleteName = singleAthleteData.get(0);
            Float[] athleteResults = new Float[10];
            for (int i = 1; i < singleAthleteData.size(); i++){
                float result = Float.parseFloat(singleAthleteData.get(i));
                athleteResults[i - 1] = result;
            }
            athleteList.add(new Athlete(athleteName, athleteResults));
        }
        return athleteList;
    }
}
