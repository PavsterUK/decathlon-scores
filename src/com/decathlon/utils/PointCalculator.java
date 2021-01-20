package com.decathlon.utils;

import com.decathlon.domain.Athlete;
import com.decathlon.domain.disciplines.Discipline;

import java.util.List;
import java.util.Set;

public class PointCalculator {

    public static void countPoints(List<Athlete> athleteList, Discipline[] disciplineList){
        for (Athlete singleAthlete : athleteList) {
            String[] results = singleAthlete.getResults();
            int totalPoints = 0;
            for (int i = 0; i < results.length; i++) {
                String eventType = disciplineList[i].evenType();
                Discipline discipline = disciplineList[i];
                float A = discipline.getA();
                float B = discipline.getB();
                float C = discipline.getC();
                String singleResult = results[i];
                totalPoints += pointCount(singleResult, discipline, A, B, C);
            }
            singleAthlete.setTotalScore(totalPoints);
        }
    }

    /*
       Track event points formula = A×(B−T)^C
       Field event points formula = A×(D−B)^C
       Math.pow requires Double as an argument, hence A B C are Doubles
     */
    private static int pointCount(String result, Discipline discipline, double A, double B, double C){
        int points;
        if (discipline.evenType().equals("Track")){
            float seconds = getSeconds(result);
            points = (int) ( A * (Math.pow(B - seconds, C)) );
        } else{
            float centimeters = (Float.parseFloat(result) * 100);
            Set<String> meterList = Set.of("Shot Put", "Discus Throw", "Javelin Throw");
            if (meterList.contains(discipline.getName())){
                centimeters /= 100;
            }
            points = (int) ( A * (Math.pow((centimeters - B), C)) );
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
