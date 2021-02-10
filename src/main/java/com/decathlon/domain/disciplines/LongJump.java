package com.decathlon.domain.disciplines;

/**
 * Represents "Long Jump" discipline
 *
 * To find documentation on all methods,
 * please refer to abstract class.
 */
public class LongJump extends Discipline {

    @Override
    public String getName() {
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
    public EventType evenType() {
        return EventType.FIELD;
    }

}
