package com.decathlon.utils;

import com.decathlon.domain.Athlete;
import com.decathlon.domain.disciplines.Discipline;
import com.decathlon.domain.disciplines.EventType;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 */
public class DecPointCalculator {

    private static final Set<String> DISCIPLINES_IN_METERS =
            new HashSet<>(Arrays.asList ("Shot Put", "Discus Throw", "Javelin Throw"));

    public static void countPoints(List<Athlete> athleteList, List<Discipline> disciplineList){
        for (Athlete singleAthlete : athleteList) {
            String[] results = singleAthlete.getResults();
            int totalPoints = 0;
            for (int i = 0; i < results.length; i++) {
                Discipline discipline = disciplineList.get(i);
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
       Track event points formula = A * (B - T)^C
       Field event points formula = A * (D - B)^C
       Math.pow requires Double as an argument, hence A B C are Doubles
     */
    private static int pointCount(String result, Discipline discipline, double A, double B, double C){
        int points;
        if (discipline.evenType().equals(EventType.TRACK)){
            float seconds = getSeconds(result);
            points = (int) ( A * (Math.pow(B - seconds, C)) );
        } else{
            float centimeters = (Float.parseFloat(result) * 100);
            if (DISCIPLINES_IN_METERS.contains(discipline.getName())){
                centimeters /= 100; // Turns into meters
            }
            points = (int) ( A * (Math.pow((centimeters - B), C)) );
        }
        return points;
    }

    private static Float getSeconds(String eventResult){
        int firstDotIndex = eventResult.indexOf('.');
        int minutes = 0;
        float seconds;
        int numOfDots = StringUtils.countMatches(eventResult, ".");

        if (numOfDots > 1){
            minutes = Integer.parseInt(eventResult.substring(0, firstDotIndex));
            seconds = Float.parseFloat(eventResult.substring(firstDotIndex + 1));
        } else {
            seconds = Float.parseFloat(eventResult);
        }

        return minutes * 60 + seconds;
    }


}
