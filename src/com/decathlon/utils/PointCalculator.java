package com.decathlon.utils;

import com.decathlon.Athlete;
import com.decathlon.disciplines.Discipline;

import java.util.List;

public class PointCalculator {

    public void countPoints(List<Athlete> athleteList, Discipline[] disciplineList){
        for (Athlete singleAthlete : athleteList) {
            String[] results = singleAthlete.getResults();
            int totalPoints = 0;
            for (int i = 0; i < results.length; i++) {
                String eventType = disciplineList[i].evenType();
                float A = disciplineList[i].getA();
                float B = disciplineList[i].getB();
                float C = disciplineList[i].getC();
                String singleResult = results[i];
                totalPoints += pointCount(singleResult, eventType, A, B, C);
            }
            singleAthlete.setTotalScore(totalPoints);
            System.out.printf(singleAthlete.getName() + " -->");
            System.out.println(singleAthlete.getTotalScore());
        }
    }

    /*
       Track event points formula = A×(B−T)^C
       Field event points formula = A×(D−B)^C
       Math.pow requires Double as an argument, hence A B C are Doubles
     */
    private int pointCount(String result, String eventType, double A, double B, double C){
        int points = 0;
        if (eventType.equals("Track")){
            float seconds = getSeconds(result);
            points = (int) Math.pow( A * (B - seconds), C);
        } else{
            float meters = Float.parseFloat(result);
            points = (int) Math.pow( A * (meters - B), C);
        }
        return points;
    }

    private Float getSeconds(String eventResult){
        int firstDotIndex = eventResult.indexOf('.');
        int minutes = 0;
        float seconds = 0;
        int numOfDots = eventResult.length() - eventResult.replace(".", "").length();

        if (numOfDots > 1){
            minutes = Integer.parseInt(eventResult.substring(0, firstDotIndex));
            seconds = Float.parseFloat(eventResult.substring(firstDotIndex + 1));
        } else {
            seconds = Float.parseFloat(eventResult);
        }

        return minutes * 60 + seconds;
    }

}
