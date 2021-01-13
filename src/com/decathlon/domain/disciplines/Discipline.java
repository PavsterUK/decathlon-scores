package com.decathlon.domain.disciplines;

public abstract class Discipline {

    public abstract String name(); //Return discipline name
    public abstract Float getA(); //Return A parameter for concrete discipline class
    public abstract Float getB(); //Return B parameter for concrete discipline class
    public abstract Float getC(); //Return C parameter for concrete discipline class
    public abstract String evenType(); //Return one of two event types, Field or Track

}
