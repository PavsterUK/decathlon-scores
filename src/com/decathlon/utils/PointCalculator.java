package com.decathlon.utils;

import com.decathlon.domain.Athlete;
import com.decathlon.domain.disciplines.Discipline;

import java.util.List;

public class PointCalculator {

    public static void countPoints(List<Athlete> athleteList, Discipline[] disciplineList){
        for (Athlete singleAthlete : athleteList) {
            String[] results = singleAthlete.getResults();
            int totalPoints = 0;
            for (int i = 0; i < results.length; i++) {
                String eventType = disciplineList[i].evenType();
                float A = disciplineList[i].getA();
                float B = disciplineList[i].getB();
                float C = disciplineList[i].getC();
                String singleResult = results[i];

                System.out.println("=====================================");
                System.out.println(singleAthlete.getName());
                System.out.println(disciplineList[i].getName());
                System.out.println(pointCount(singleResult, eventType, A, B, C));
                System.out.println(singleResult);
                System.out.println("=====================================");

                totalPoints += pointCount(singleResult, eventType, A, B, C);
            }
            singleAthlete.setTotalScore(totalPoints);
        }
    }

    /*
       Track event points formula = A×(B−T)^C
       Field event points formula = A×(D−B)^C
       Math.pow requires Double as an argument, hence A B C are Doubles
     */
    private static int pointCount(String result, String eventType, double A, double B, double C){
        int points;
        if (eventType.equals("Track")){
            float seconds = getSeconds(result);
            double temp = Math.pow(B - seconds, C);
            points = (int) (A * temp);
        } else{
            float meters = Float.parseFloat(result);
            points = (int) Math.pow( A * (meters - B), C);
        }
        return points;
    }

    private static Float getSeconds(String eventResult){
        int firstDotIndex = eventResult.indexOf('.');
        int minutes = 0;
        float seconds;
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
