package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class ShotPut extends Discipline {

    private final boolean isWomenTournament;

    public ShotPut(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        return "Shot Put";
    }

    @Override
    public float getA() {
        if (isWomenTournament) {
            return  56.0211f;
        }
        return 51.39f;
    }

    @Override
    public float getB() {
        return 1.5f;
    }

    @Override
    public float getC() {
        return 1.05f;
    }

    @Override
    public String evenType() {
        return "Field";
    }

}
