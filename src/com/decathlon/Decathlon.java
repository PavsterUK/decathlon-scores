package com.decathlon;

import com.decathlon.disciplines.*;
import com.decathlon.utils.CSVParser;

import java.io.File;
import java.util.List;

public class Decathlon {

    private Discipline[] disciplineList = new Discipline[10];

    public Decathlon(){
        makeDisciplinesList();
    }

    public List<Athlete> createAthleteList(File csvFile){
        return CSVParser.getAthleteList(
                CSVParser.getData(csvFile));
    }

    public void makeDisciplinesList(){
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





}
