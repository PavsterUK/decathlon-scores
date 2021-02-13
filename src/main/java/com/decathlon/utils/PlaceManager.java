package com.decathlon.utils;

import com.decathlon.domain.Athlete;
import java.util.Comparator;
import java.util.List;

/**
 * Utility Class to arrange athlete places
 * according to their results. In case when
 * more than one athlete have same score,
 * places will be shared between them.
 *
 */
public class PlaceManager {

    /**
     * Sort list in descending order based on athletes
     * total score. Arrange places based on total scores,
     * check if any of athletes have identical scores.
     * Share places between same score athletes.
     *
     * @param athleteList [List<Athlete>] Athlete list.
     */
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
                athleteList.get(i).setPlace(String.valueOf(i + 1));
                i++;
            }
        }
    }

    /**
     * Helper method to share places between athletes in case of
     * multiple identical scores.
     *
     * @param athleteList [List<Athlete>] list of athletes.
     * @param numOfSame [int] Number of same score athletes.
     * @param startIndex [int] Index of first athlete with same score.
     */
    private static void sharePlaces(List<Athlete> athleteList, int numOfSame, int startIndex){
        int place = startIndex + 1;
        for (int i = startIndex; i < startIndex + numOfSame + 1; i++) {
            athleteList.get(i).setPlace(place + "-" + (place + numOfSame));
        }
    }

    /**
     * Helper method to find how many athletes have same score.
     *
     * @param athleteList [List<Athlete>] List of athletes.
     * @param score [int] Score to check for duplicates.
     * @return [int] Number of athletes with same score, excluding
     *               score that is compared against.
     *
     */
    private static int numSameScore(List<Athlete> athleteList, int score){
        int sameScores = 0;
        for (Athlete athlete : athleteList){
            if (athlete.getTotalScore() == score){
                sameScores++;
            }
        }
        return sameScores - 1;
    }

    /**
     * Arranges List<Athlete> in descending order
     * based on their totalScore.

     * @param athleteList [List<Athlete>] List of athletes.
     */
    private static void sortAthleteList(List<Athlete> athleteList){
        athleteList.sort(Comparator
                .comparingInt(Athlete::getTotalScore)
                .reversed());
    }

}
