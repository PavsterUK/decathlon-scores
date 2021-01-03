package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class HundredMeters extends Discipline {

    private final boolean isWomenTournament;

    public HundredMeters(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        return "100m";
    }

    @Override
    public float getA() {
        if (isWomenTournament) {
            return 17.8570f;
        }
        return 25.4347f;
    }

    @Override
    public float getB() {
        if (isWomenTournament) {
            return 21.0f;
        }
        return 18.0f;
    }

    @Override
    public float getC() {
        return 1.81f;
    }

    @Override
    public String evenType() {
        return "Track";
    }
}
