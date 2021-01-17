package com.decathlon.utils;

import com.decathlon.domain.Athlete;
import java.util.Comparator;
import java.util.List;

public class PlaceManager {

    public static void arrangePlaces(List<Athlete> athleteList){
        sortAthleteList(athleteList);
        for (int i = 0; i < athleteList.size();) {
            Athlete athlete = athleteList.get(i);
            int score = athlete.getTotalScore();
            int numOfSame = numSameScore(athleteList, score);

            if (numOfSame > 0){
                sharePlaces(athleteList, numOfSame, i);
                i += numOfSame + 1;
            }else {
                athleteList.get(i).setPlace( (i + 1) + "");
                i++;
            }
        }
    }

    private static void sharePlaces(List<Athlete> athleteList, int numOfSame, int startIndex){
        int place = startIndex + 1;
        StringBuilder sharedPlaces = new StringBuilder();
        sharedPlaces.append(place);
        for (int i = place; i < startIndex + numOfSame + 1; i++) {
            sharedPlaces.append("-").append(i + 1);
        }
        for (int i = startIndex; i < startIndex + numOfSame + 1; i++) {
            athleteList.get(i).setPlace(sharedPlaces.toString());
        }
    }

    //Check how many athletes have same score as argument
    private static int numSameScore(List<Athlete> athleteList, int score){
        int sameScores = 0;
        for (Athlete athlete : athleteList){
            if (athlete.getTotalScore() == score){
                sameScores++;
            }
        }
        return sameScores - 1;
    }

    private static void sortAthleteList(List<Athlete> athleteList){
        athleteList.sort(Comparator
                .comparingInt(Athlete::getTotalScore)
                .reversed());
    }

}
