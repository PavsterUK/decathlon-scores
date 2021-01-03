package com.decathlon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ParseCSV {

    //Read File into List<List<String>>
    public static List<List<String>> getData(File inputFile)  {
        List<List<String>> athletesData = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(";");
                athletesData.add(Arrays.asList(values));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return athletesData;
    }

    //Process athleteData into Obj<Athlete> list
    public static List<Athlete> getAthletesList(List<List<String>> athletesData, boolean isWomenTournament){
        List<Athlete> athleteList = new ArrayList<>();
        for (List<String> singleAthleteData : athletesData){
            String athletesName = "";
            ArrayList<Float> athletesResults = new ArrayList<>();
            for (int i = 0; i < singleAthleteData.size(); i++){
                if (i == 0){
                  athletesName = singleAthleteData.get(i);
                } else {
                  Float result = Float.parseFloat(singleAthleteData.get(i));
                  athletesResults.add(i, result);
                }
            }
            athleteList.add(new Athlete(athletesName, isWomenTournament, athletesResults));
        }
        return athleteList;
    }

}
