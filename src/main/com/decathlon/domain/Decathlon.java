package com.decathlon.domain;

import com.decathlon.domain.disciplines.*;
import com.decathlon.utils.PlaceManager;
import com.decathlon.utils.PointCalculator;

import java.util.List;

/**
 * This class puts together a list of sport
 * disciplines in specific order, simulating
 * Decathlon tournament. It takes list of Athletes
 * in a constructor, representing competing athletes
 * in given tournament.
 *
 * By calling @initialize method, it will
 * calculate scores for each individual athlete
 * and assign places according to their
 * scores.
 */
public class Decathlon {

    private final Discipline[] DISCIPLINES_LIST = new Discipline[10];// List of disciplines in Decathlon.
    private final List<Athlete> ATHLETE_LIST; // List of Athletes participating in Tournament.

    /**
     * Constructor.
     *
     * @param athleteList [List<Athlete>]list of athletes participating
     * in Decathlon.
     *
     * makeDisciplinesList() method populates DISCIPLINES_LIST field
     * variable with disciplines of Decathlon tournament.
     */
    public Decathlon(List<Athlete> athleteList){
        this.ATHLETE_LIST = athleteList;
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
        DISCIPLINES_LIST[0] = new HundredMeters();
        DISCIPLINES_LIST[1] = new LongJump();
        DISCIPLINES_LIST[2] = new ShotPut();
        DISCIPLINES_LIST[3] = new HighJump();
        DISCIPLINES_LIST[4] = new FourHundredMeters();
        DISCIPLINES_LIST[5] = new OutdoorHurdles();
        DISCIPLINES_LIST[6] = new DiscusThrow();
        DISCIPLINES_LIST[7] = new PoleVault();
        DISCIPLINES_LIST[8] = new JavelinThrow();
        DISCIPLINES_LIST[9] = new FifteenHundredMeters();
    }

    /**
     * Uses utility class PointCalculator to calculate
     * points for athletes from a field ATHLETE_LIST.
     * It updates ATHLETE_LIST field, adding counted points
     * for each athlete.
     */
    private void countPoints(){
        PointCalculator.countPoints(ATHLETE_LIST, DISCIPLINES_LIST);
    }

    /**
     * Uses utility class PlaceManager to arrange places for each
     * athlete in ATHLETE_LIST field.
     */
    private void arrangePlaces(){
        PlaceManager.arrangePlaces(ATHLETE_LIST);
    }

    /**
     *
     * Returns ATHLETE_LIST field variable.
     */
    public List<Athlete> getATHLETE_LIST() {
        return ATHLETE_LIST;
    }
}
