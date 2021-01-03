package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class DiscusThrow extends Discipline {

    private final boolean isWomenTournament;

    public DiscusThrow(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        return "Discus Throw";
    }

    @Override
    public float getA() {
        if (isWomenTournament) {
            return 12.3311f;
        }
        return 12.91f;
    }

    @Override
    public float getB() {
        if (isWomenTournament) {
            return 3.00f;
        }
        return 4f;
    }

    @Override
    public float getC() {
        if (isWomenTournament) {
            return 1.10f;
        }
        return 1.1f;
    }

    @Override
    public String evenType() {
        return "Field";
    }
}
