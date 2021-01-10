package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class JavelinThrow extends Discipline {

    @Override
    public String name() {
        return "Javelin Throw";
    }

    @Override
    public Float getA() {
        return 10.14f;
    }

    @Override
    public Float getB() {
        return 7f;
    }

    @Override
    public Float getC() {
        return 1.08f;
    }

    @Override
    public String evenType() {
        return "Field";
    }
}
