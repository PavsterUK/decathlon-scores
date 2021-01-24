package com.decathlon.domain.disciplines;

/**
 * Abstract base Class representing sport discipline.
 */
public abstract class Discipline {

    /**
     * This method must be implemented to return a
     * name of sport discipline in concrete class.
     *
     * @return name of sport discipline as String
     */
    public abstract String getName();

    /**
     * This method must
     * return "A" parameter for discipline
     * implemented in concrete class
     *
     * @return float "A" parameter.
     */
    public abstract Float getA(); //Return "A" parameter for concrete discipline class

    /**
     * This method must
     * return "B" parameter for discipline
     * implemented in concrete class
     *
     * @return float "B" parameter.
     */
    public abstract Float getB(); //Return "B" parameter for concrete discipline class

    /**
     * This method must
     * return "C" parameter for discipline
     * implemented in concrete class
     *
     * @return float "C" parameter.
     */
    public abstract Float getC(); //Return "C" parameter for concrete discipline class

    /**
     * This method must return one of two
     * event types, "Track" or "Field",
     * depending on discipline implemented
     * in concrete class.
     *
     * @return event type as String
     */
    public abstract String evenType(); //Return one of two event types, "Field" or "Track"

}
