package com.boda.UsedClass;

public abstract class Circle {

    public String shapeName;

    protected double radius;

    public Circle(){};

    public Circle(String name,double r){
        this.radius=r;
        this.shapeName=name;
    }

    public abstract double getArea();

}
