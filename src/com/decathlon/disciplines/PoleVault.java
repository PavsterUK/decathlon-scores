package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class PoleVault extends Discipline {

    private final boolean isWomenTournament;

    public PoleVault(boolean womenTournament) {
        this.isWomenTournament = womenTournament;
    }

    @Override
    public String name() {
        return "Pole Vault";
    }

    @Override
    public Float getA() {
        if (isWomenTournament) {
            return 0.44125f;
        }
        return 0.2797f;
    }

    @Override
    public Float getB() {
        if (isWomenTournament) {
            return 100f;
        }
        return 100f;
    }

    @Override
    public Float getC() {
        if (isWomenTournament) {
            return 1.35f;
        }
        return 1.35f;
    }

    @Override
    public String evenType() {
        return "Field";
    }
}
