package com.decathlon;

import com.decathlon.disciplines.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Decathlon {

    private boolean isWomenTournament; //True if it is ladies event
    private Discipline[] disciplineList = new Discipline[10];

    public Decathlon(boolean womenTournament){
        isWomenTournament = womenTournament;
        makeDisciplinesList();
    }


    public List<Athlete> createAthleteList(File csvFile){
        return ParseCSV.getAthletesList(
                ParseCSV.getData(csvFile)
        );
    }

    public void makeDisciplinesList(){
        /*
        When parsing from csv file, numerical results begin from
        index 1, hence disciplineList below begins from index 1 too.
         */
        disciplineList[0] = new HundredMeters(isWomenTournament);
        disciplineList[1] = new LongJump(isWomenTournament);
        disciplineList[2] = new ShotPut(isWomenTournament);
        disciplineList[3] = new HighJump(isWomenTournament);
        disciplineList[4] = new FourHundredMeters(isWomenTournament);
        disciplineList[5] = new OutdoorHurdles(isWomenTournament);
        disciplineList[6] = new DiscusThrow(isWomenTournament);
        disciplineList[7] = new PoleVault(isWomenTournament);
        disciplineList[8] = new JavelinThrow(isWomenTournament);
        disciplineList[9] = new FifteenHundredMeters(isWomenTournament);
    }

    public void CalculatePoints(List<Athlete> athleteList){
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
       Track event points formula = A×(B−T)^C  ||  Field event points formula = A×(D−B)^C
       Math.pow requires Double as an argument, that is why arguments A B C are Doubles
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
