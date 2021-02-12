package com.decathlon.domain;

import com.decathlon.domain.disciplines.*;
import com.decathlon.utils.PlaceManager;
import com.decathlon.utils.DecPointCalculator;

import java.util.ArrayList;
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
    private final List<Discipline> disciplinesList = new ArrayList<>(10);

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
        disciplinesList.add( new HundredMeters());
        disciplinesList.add( new LongJump());
        disciplinesList.add( new ShotPut());
        disciplinesList.add( new HighJump());
        disciplinesList.add( new FourHundredMeters());
        disciplinesList.add( new OutdoorHurdles());
        disciplinesList.add( new DiscusThrow());
        disciplinesList.add( new PoleVault());
        disciplinesList.add( new JavelinThrow());
        disciplinesList.add( new FifteenHundredMeters());
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
