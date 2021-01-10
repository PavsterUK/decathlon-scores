package com.decathlon;

import java.util.List;

public class PointCalculator {

    public void CalculatePoints(List<Athlete> athleteList, Discipline[] disciplineList){
        for (Athlete singleAthlete : athleteList) {
            Float[] results = singleAthlete.getResults();
            int totalPoints = 0;
            for (int i = 0; i < results.length; i++) {
                String eventType = disciplineList[i].evenType();
                float A = disciplineList[i].getA();
                float B = disciplineList[i].getB();
                float C = disciplineList[i].getC();
                Float singleResult = results[i];
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
    private int pointCount(Float result, String eventType, double A, double B, double C){
        int points = 0;
        if (eventType.equals("Track")){
            points = (int) Math.pow( A * (B - result), C);
        }
        else{
            points = (int) Math.pow( A * (result - B), C);
        }
        return points;
    }
}
