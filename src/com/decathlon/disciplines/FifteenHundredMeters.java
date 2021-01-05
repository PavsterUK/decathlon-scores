package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class FifteenHundredMeters extends Discipline {

    private final boolean isWomenTournament;

    public FifteenHundredMeters(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        return "1500m";
    }

    @Override
    public Float getA() {
        if (isWomenTournament) {
            return  0.02883f;
        }
        return 0.03768f;
    }

    @Override
    public Float getB() {
        if (isWomenTournament) {
            return 535f;
        }
        return 480f;
    }

    @Override
    public Float getC() {
        if (isWomenTournament) {
            return 1.81f;
        }
        return 1.85f;
    }

    @Override
    public String evenType() {
        return "Track";
    }
}
