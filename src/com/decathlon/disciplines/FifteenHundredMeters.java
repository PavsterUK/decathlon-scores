package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class FifteenHundredMeters extends Discipline {

    @Override
    public String name() {
        return "1500m";
    }

    @Override
    public Float getA() {
        return 0.03768f;
    }

    @Override
    public Float getB() {
        return 480f;
    }

    @Override
    public Float getC() {
        return 1.85f;
    }

    @Override
    public String evenType() {
        return "Track";
    }
}
