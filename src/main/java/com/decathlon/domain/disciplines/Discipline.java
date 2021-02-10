package com.decathlon.domain.disciplines;

/**
 * Abstract base Class representing sport discipline.
 */
public abstract class Discipline {

    /**
     * This method must be implemented to return a
     * name of sport discipline in concrete class.
     *
     * @return [String] name of sport discipline
     */
    public abstract String getName();

    /**
     * This method must
     * return "A" parameter for discipline
     * implemented in concrete class
     *
     * @return [float] "A" parameter.
     */
    public abstract Float getA();

    /**
     * This method must
     * return "B" parameter for discipline
     * implemented in concrete class
     *
     * @return [float] "B" parameter.
     */
    public abstract Float getB();

    /**
     * This method must
     * return "C" parameter for discipline
     * implemented in concrete class
     *
     * @return [float] "C" parameter.
     */
    public abstract Float getC();

    /**
     * This method must return one of two
     * event types, "Track" or "Field",
     * depending on discipline implemented
     * in concrete class.
     *
     * @return [String] event type
     */
    public abstract EventType evenType();

}
