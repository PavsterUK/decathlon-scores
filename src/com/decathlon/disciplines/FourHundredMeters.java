package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class FourHundredMeters extends Discipline {

    private final boolean isWomenTournament;

    public FourHundredMeters(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        return "400m";
    }

    @Override
    public float getA() {
        if (isWomenTournament) {
            return 1.34285f;
        }
        return 1.53775f;
    }

    @Override
    public float getB() {
        if (isWomenTournament) {
            return 91.7f;
        }
        return 82f;
    }

    @Override
    public float getC() {
        if (isWomenTournament) {
            return 1.81f;
        }
        return 1.81f;
    }

    @Override
    public String evenType() {
        return "Track";
    }

}
