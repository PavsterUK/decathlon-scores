package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class FourHundredMeters extends Discipline {

    @Override
    public String name() {
        return "400m";
    }

    @Override
    public Float getA() {
        return 1.53775f;
    }

    @Override
    public Float getB() {
        return 82f;
    }

    @Override
    public Float getC() {
        return 1.81f;
    }

    @Override
    public String evenType() {
        return "Track";
    }

}
