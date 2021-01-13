package com.decathlon.domain;

import com.decathlon.domain.disciplines.*;
import com.decathlon.utils.PlaceManager;
import com.decathlon.utils.PointCalculator;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Decathlon {

    private final Discipline[] disciplineList = new Discipline[10];
    private final List<Athlete> athleteList;

    public Decathlon(List<Athlete> athleteList){
        this.athleteList = athleteList;
        makeDisciplinesList();
        countPoints();
        arrangePlaces();
    }

    public final void makeDisciplinesList(){
        disciplineList[0] = new HundredMeters();
        disciplineList[1] = new LongJump();
        disciplineList[2] = new ShotPut();
        disciplineList[3] = new HighJump();
        disciplineList[4] = new FourHundredMeters();
        disciplineList[5] = new OutdoorHurdles();
        disciplineList[6] = new DiscusThrow();
        disciplineList[7] = new PoleVault();
        disciplineList[8] = new JavelinThrow();
        disciplineList[9] = new FifteenHundredMeters();
    }

    public void countPoints(){
        PointCalculator.countPoints(athleteList, disciplineList);
    }

    public void arrangePlaces(){
        PlaceManager.arrangePlaces(athleteList);
    }

    public List<Athlete> getAthleteList() {
        return athleteList;
    }
}
