package com.decathlon.disciplines;

import com.decathlon.Discipline;

public class LongJump extends Discipline {

    @Override
    public String name() {
        return "Long Jump";
    }

    @Override
    public Float getA() {
        return 0.14354f;
    }

    @Override
    public Float getB() {
        return 220f;
    }

    @Override
    public Float getC() {
        return 1.4f;
    }

    @Override
    public String evenType() {
        return "Field";
    }

}
