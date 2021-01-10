package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class OutdoorHurdles extends Discipline {

    @Override
    public String name() {
        return "110m Hurdles";
    }

    @Override
    public Float getA() {
        return 5.74352f;
    }

    @Override
    public Float getB() {
        return 28.5f;
    }

    @Override
    public Float getC() {
        return 1.92f;
    }

    @Override
    public String evenType() {
        return "Track";
    }
}
