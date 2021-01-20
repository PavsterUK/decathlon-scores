package com.decathlon.domain.disciplines;

public class HighJump extends Discipline {

    @Override
    public String getName() {
        return "High Jump";
    }

    @Override
    public Float getA() {
        return 0.8465f;
    }

    @Override
    public Float getB() {
        return 75f;
    }

    @Override
    public Float getC() {
        return 1.42f;
    }

    @Override
    public String evenType() {
        return "Field";
    }
}
