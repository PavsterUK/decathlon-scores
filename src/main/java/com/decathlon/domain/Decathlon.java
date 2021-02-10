package com.decathlon.domain;

import com.decathlon.domain.disciplines.*;
import com.decathlon.utils.PlaceManager;
import com.decathlon.utils.DecPointCalculator;

import java.util.List;

/**
 * This class puts together a list of sport
 * disciplines in specific order, simulating
 * Decathlon tournament. It takes list of Athletes
 * in a constructor, representing competing athletes
 * in given tournament.
 *
 * Calling @initialize method, it will
 * calculate scores for each individual athlete
 * and assign places according to their
 * scores.
 */
public class Decathlon {

    // List of disciplines in Decathlon.
    private final Discipline[] disciplinesList = new Discipline[10];

    // List of Athletes participating in Tournament.
    private final List<Athlete> athleteList;

    /**
     * Constructor.
     *
     * @param athleteList [List<Athlete>]list of athletes participating
     * in Decathlon.
     *
     * makeDisciplinesList() method populates disciplinesList field
     * variable with disciplines of Decathlon tournament.
     */
    public Decathlon(List<Athlete> athleteList){
        this.athleteList = athleteList;
        makeDisciplinesList();
    }

    /**
     * Method-initializer, calls up two private
     * methods to count points and arrange
     * places of athletes.
     */
    public void initialize(){
        countPoints();
        arrangePlaces();
    }

    /**
     * Official list of Men Decathlon disciplines,
     * ordered according to internationally used
     * standards.
     */
    public final void makeDisciplinesList(){
        disciplinesList[0] = new HundredMeters();
        disciplinesList[1] = new LongJump();
        disciplinesList[2] = new ShotPut();
        disciplinesList[3] = new HighJump();
        disciplinesList[4] = new FourHundredMeters();
        disciplinesList[5] = new OutdoorHurdles();
        disciplinesList[6] = new DiscusThrow();
        disciplinesList[7] = new PoleVault();
        disciplinesList[8] = new JavelinThrow();
        disciplinesList[9] = new FifteenHundredMeters();
    }

    /**
     * Uses utility class PointCalculator to calculate
     * points for athletes from a field athleteList.
     * It updates athleteList field, adding counted points
     * for each athlete.
     */
    private void countPoints(){
        DecPointCalculator.countPoints(athleteList, disciplinesList);
    }

    /**
     * Uses utility class PlaceManager to arrange places for each
     * athlete in athleteList field.
     */
    private void arrangePlaces(){
        PlaceManager.arrangePlaces(athleteList);
    }

    /**
     * Returns athleteList field variable.
     */
    public List<Athlete> getAthleteList() {
        return athleteList;
    }
}
