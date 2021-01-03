package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class OutdoorHurdles extends Discipline {
    private final boolean isWomenTournament;

    public OutdoorHurdles(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        if (isWomenTournament){
            return "100m Hurdles";
        }
        return "110m Hurdles";
    }

    @Override
    public float getA() {
        if (isWomenTournament) {
            return 9.23076f;
        }
        return 5.74352f;
    }

    @Override
    public float getB() {
        if (isWomenTournament) {
            return  26.70f;
        }
        return 28.5f;
    }

    @Override
    public float getC() {
        if (isWomenTournament) {
            return 1.835f;
        }
        return 1.92f;
    }

    @Override
    public String evenType() {
        return "Track";
    }
}
