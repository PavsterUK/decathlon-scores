package com.decathlon;



public class Athlete {

    private String name; //Athlete Name
    private String[] results; //Athlete results
    private int totalScore; //Final total score

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
}
