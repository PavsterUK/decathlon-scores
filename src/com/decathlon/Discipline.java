package com.decathlon;

public abstract class Discipline {

    public abstract String name(); //Return discipline name
    public abstract float getA(); //Return A parameter for concrete discipline class
    public abstract float getB(); //Return B parameter for concrete discipline class
    public abstract float getC(); //Return C parameter for concrete discipline class
    public abstract String evenType(); //Return one of two event types, Field or Track

}
