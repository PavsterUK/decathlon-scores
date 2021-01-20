package com.decathlon.domain.disciplines;


/**
 * Represents "Shot Put" discipline
 *
 * In order to find documentation on all method within
 * the class, please refer to abstract class.
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
    public String evenType() {
        return "Field";
    }

}
