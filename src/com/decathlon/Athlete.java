package com.decathlon;



public class Athlete {

    private final String name; //Athlete Name

    private final String[] results; //Athlete results
    private int totalScore; //Final total score
    private int place;

    public Athlete(String name, String[] results){
        this.name = name;
        this.results = results;
    }

    public String getName() {
        return name;
    }

    public String[] getResults() {
        return results;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int score) {
        totalScore = score;
    }

    public int getPlace() {
        return place;
    }
}
