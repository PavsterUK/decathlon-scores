package com.decathlon.domain;


/**
 * Represents an athlete.
 */

public class Athlete {

    //Athlete's full Name.
    private final String name;

    //Athlete's results parsed from CSV file, each result as separate string.
    private final String[] results;

    //Combined scores for all disciplines.
    private int totalScore;

    //Athlete's place on competition.
    private String place;

    /**
     * Constructor
     *
     * @param results [String[] ] Athlete's results parsed from CSV file, each result as separate string.
     * @param name [String] Athlete's full name.
     */
    public Athlete(String name, String[] results){
        this.name = name;
        this.results = results;
    }

    /**
     * Getter for @name field
     * @return  @name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter for @results field
     * @return @results
     */
    public String[] getResults() {
        return results;
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
