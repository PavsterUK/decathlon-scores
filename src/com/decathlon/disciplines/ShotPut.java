package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class ShotPut extends Discipline {

    @Override
    public String name() {
        return "Shot Put";
    }

    @Override
    public Float getA() {
        return 51.39f;
    }

    @Override
    public Float getB() {
        return 1.5f;
    }

    @Override
    public Float getC() {
        return 1.05f;
    }

    @Override
    public String evenType() {
        return "Field";
    }

}
