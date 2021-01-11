package com.decathlon.disciplines;

public class HundredMeters extends Discipline {

    @Override
    public String name() {
        return "100m";
    }

    @Override
    public Float getA() {
        return 25.4347f;
    }

    @Override
    public Float getB() {
        return 18.0f;
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
