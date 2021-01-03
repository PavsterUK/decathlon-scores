package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class HighJump extends Discipline {

    private final boolean isWomenTournament;

    public HighJump(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        return "High Jump";
    }

    @Override
    public float getA() {
        if (isWomenTournament) {
            return 1.84523f;
        }
        return 0.8465f;
    }

    @Override
    public float getB() {
        return 75f;
    }

    @Override
    public float getC() {
        if (isWomenTournament) {
            return 1.348f;
        }
        return 1.42f;
    }

    @Override
    public String evenType() {
        return "Field";
    }
}
