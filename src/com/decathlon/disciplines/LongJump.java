package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class LongJump extends Discipline {

    private final boolean isWomenTournament;

    public LongJump(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        return "Long Jump";
    }

    @Override
    public float getA() {
        if (isWomenTournament) {
            return 0.188807f;
        }
        return 0.14354f;
    }

    @Override
    public float getB() {
        if (isWomenTournament) {
            return 210.00f;
        }
        return 220f;
    }

    @Override
    public float getC() {
        if (isWomenTournament) {
            return 1.41f;
        }
        return 1.4f;
    }

    @Override
    public String evenType() {
        return "Field";
    }

}
