package com.decathlon.domain.disciplines;

public class PoleVault extends Discipline {

    @Override
    public String getName() {
        return "Pole Vault";
    }

    @Override
    public Float getA() {
        return 0.2797f;
    }

    @Override
    public Float getB() {
        return 100f;
    }

    @Override
    public Float getC() {
        return 1.35f;
    }

    @Override
    public String evenType() {
        return "Field";
    }
}
