package com.decathlon.domain.disciplines;

/**
 * Represents "100-meter run" discipline
 *
 * To find documentation on all methods,
 * please refer to abstract class.
 */
public class HundredMeters extends Discipline {

    @Override
    public String getName() {
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
    public EventType evenType() {
        return EventType.TRACK;
    }
}
