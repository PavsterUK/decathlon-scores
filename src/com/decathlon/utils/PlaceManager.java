package com.decathlon.utils;

import com.decathlon.domain.Athlete;
import java.util.Comparator;
import java.util.List;

public class PlaceManager {

    public static void arrangePlaces(List<Athlete> athleteList){
        sortAthleteList(athleteList);
        for (int i = 0; i < athleteList.size(); i++) {
            Athlete athlete = athleteList.get(i);
            int score = athlete.getTotalScore();
            int numOfSame = numSameScore(athleteList, score);

            if (numOfSame > 0){
                sharePlaces(athleteList, numOfSame, i);
            }else {
                athleteList.get(i).setPlace( i + 1 + "");
            }
        }
    }

    private static void sharePlaces(List<Athlete> athleteList, int numOfSame, int startIndex){
        startIndex += 1; //Compensate +1 to avoid 0th place
        String sharedPlaces = startIndex + "";
        for (int i = startIndex + 1; i < startIndex + numOfSame; i++) {
            sharedPlaces += " - " +  i;
        }
        for (int i = startIndex - 1; i < startIndex + numOfSame; i++) {
            if ( i > athleteList.size())break;
            athleteList.get(i).setPlace(sharedPlaces);
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
