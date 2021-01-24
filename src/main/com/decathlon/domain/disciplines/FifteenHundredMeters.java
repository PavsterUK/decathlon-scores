package com.decathlon.domain.disciplines;

/**
 * Represents "1500-meter run" discipline
 *
 * In order to find documentation on all method within
 * the class, please refer to abstract class.
 */
public class FifteenHundredMeters extends Discipline {

    @Override
    public String getName() {
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
