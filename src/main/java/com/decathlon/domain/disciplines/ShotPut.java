package com.decathlon.domain.disciplines;


/**
 * Represents "Shot Put" discipline
 *
 * To find documentation on all methods,
 * please refer to abstract class.
 */
public class ShotPut extends Discipline {

    @Override
    public String getName() {
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
    public EventType evenType() {
        return EventType.FIELD;
    }

}
