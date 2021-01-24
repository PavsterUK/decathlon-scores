package com.decathlon.domain.disciplines;

/**
 * Represents "Javelin Throw" discipline
 *
 * In order to find documentation on all method within
 * the class, please refer to abstract class.
 */
public class JavelinThrow extends Discipline {

    @Override
    public String getName() {
        return "Javelin Throw";
    }

    @Override
    public Float getA() {
        return 10.14f;
    }

    @Override
    public Float getB() {
        return 7f;
    }

    @Override
    public Float getC() {
        return 1.08f;
    }

    @Override
    public String evenType() {
        return "Field";
    }
}
