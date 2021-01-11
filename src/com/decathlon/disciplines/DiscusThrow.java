package com.decathlon.disciplines;

public class DiscusThrow extends Discipline {


    @Override
    public String name() {
        return "Discus Throw";
    }

    @Override
    public Float getA() {
        return 12.91f;
    }

    @Override
    public Float getB() {
        return 4f;
    }

    @Override
    public Float getC() {
        return 1.1f;
    }

    @Override
    public String evenType() {
        return "Field";
    }
}
