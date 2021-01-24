package com.decathlon.domain.disciplines;

/**
 * Represents "High Jump" discipline
 *
 * In order to find documentation on all method within
 * the class, please refer to abstract class.
 */
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
