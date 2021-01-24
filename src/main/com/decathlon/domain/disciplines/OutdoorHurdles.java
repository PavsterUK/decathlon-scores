package com.decathlon.domain.disciplines;

/**
 * Represents "110-meter hurdle run " discipline
 *
 * In order to find documentation on all method within
 * the class, please refer to abstract class.
 */
public class OutdoorHurdles extends Discipline {

    @Override
    public String getName() {
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