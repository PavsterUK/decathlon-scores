package com.decathlon.domain.disciplines;

/**
 * Represents "Discus Throw" discipline
 *
 * In order to find documentation on all method within
 * the class, please refer to abstract class.
 */

public class DiscusThrow extends Discipline {


    @Override
    public String getName() {
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
    public EventType evenType() {
        return EventType.FIELD;
    }
}
