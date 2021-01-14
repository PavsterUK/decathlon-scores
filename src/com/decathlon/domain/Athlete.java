package com.decathlon.domain;



public class Athlete {

    private final String NAME; //Athlete Name
    private final String[] RESULTS; //Athlete results
    private int totalScore; //Final total score
    private String place; //

    public Athlete(String name, String[] results){
        this.NAME = name;
        this.RESULTS = results;
    }

    public String getName() {
        return NAME;
    }

    public String[] getResults() {
        return RESULTS;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int score) {
        totalScore = score;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }



}
