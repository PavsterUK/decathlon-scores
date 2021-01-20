package com.decathlon.domain.disciplines;

/**
 * Represents "Long Jump" discipline
 *
 * In order to find documentation on all method within
 * the class, please refer to abstract class.
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
    public String evenType() {
        return "Field";
    }

}
