package com.decathlon.domain;


/**
 * Represents an athlete.
 */

public class Athlete {

    private final String NAME; //Athlete's full Name.
    private final String[] RESULTS; //Athlete's results parsed from CSV file, each result as separate string.
    private int totalScore; //Combined scores for all disciplines.
    private String place; //Athlete's place on competition.

    /**
     * Constructor
     *
     * @param results [String[] ] Athlete's results parsed from CSV file, each result as separate string.
     * @param name [String] Athlete's full name.
     */
    public Athlete(String name, String[] results){
        this.NAME = name;
        this.RESULTS = results;
    }

    /**
     * Getter for @NAME field
     * @return  @NAME
     */
    public String getName() {
        return NAME;
    }

    /**
     * Getter for @RESULTS field
     * @return @RESULTS
     */
    public String[] getResults() {
        return RESULTS;
    }

    /**
     * Getter for @totalScore field
     * @return @totalScore
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * Setter for @totalScore field.
     * @param score updates value of @totalScore field.
     */
    public void setTotalScore(int score) {
        totalScore = score;
    }

    /**
     * Getter for @place field.
     * @return @place
     */
    public String getPlace() {
        return place;
    }

    /**
     * Setter for @place field
     * @param place updates value of @place field.
     */
    public void setPlace(String place) {
        this.place = place;
    }



}
