package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class JavelinThrow extends Discipline {

    private final boolean isWomenTournament;

    public JavelinThrow(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        return "Javelin Throw";
    }

    @Override
    public Float getA() {
        if (isWomenTournament) {
            return  15.9803f;
        }
        return 10.14f;
    }

    @Override
    public Float getB() {
        if (isWomenTournament) {
            return 3.80f;
        }
        return 7f;
    }

    @Override
    public Float getC() {
        if (isWomenTournament) {
            return  1.04f;
        }
        return 1.08f;
    }

    @Override
    public String evenType() {
        return "Field";
    }
}
