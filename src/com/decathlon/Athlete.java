package com.decathlon;

import java.util.ArrayList;

public class Athlete {

    private String name; //Athlete Name
    private boolean isFemale; //Athlete gender
    private ArrayList<Float> results; //Athlete results
    private int totalScore; //Final total score

    public Athlete(String name, boolean isFemale, ArrayList<Float> results){
        this.isFemale = isFemale;
        this.name = name;
        this.results = results;
    }


    public String getName() {
        return name;
    }

    public boolean isFemale() {
        return isFemale;
    }

    public ArrayList<Float> getResults() {
        return results;
    }

    public int getTotalScore() {
        return totalScore;
    }
}
