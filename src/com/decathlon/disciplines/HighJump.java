package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class HighJump extends Discipline {

    @Override
    public String name() {
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
