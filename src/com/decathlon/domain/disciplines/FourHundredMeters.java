package com.decathlon.domain.disciplines;

/**
 * Represents "400-meter run" discipline
 *
 * In order to find documentation on all method within
 * the class, please refer to abstract class.
 */
public class FourHundredMeters extends Discipline {

    @Override
    public String getName() {
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
