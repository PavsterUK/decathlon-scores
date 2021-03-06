package com.decathlon.domain.disciplines;

/**
 * Represents "Pole Vault" discipline
 *
 * To find documentation on all methods,
 * please refer to abstract class.
 */
public class PoleVault extends Discipline {

    @Override
    public String getName() {
        return "Pole Vault";
    }

    @Override
    public Float getA() {
        return 0.2797f;
    }

    @Override
    public Float getB() {
        return 100f;
    }

    @Override
    public Float getC() {
        return 1.35f;
    }

    @Override
    public EventType evenType() {
        return EventType.FIELD;
    }
}
