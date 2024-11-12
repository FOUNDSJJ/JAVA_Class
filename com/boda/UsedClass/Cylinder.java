package com.boda.UsedClass;

public class Cylinder extends  Circle{

    public static final double PI = 3.14;

    public double height;

    public Cylinder(){};

    public Cylinder(double height,double radius){
        super("Cylinder",radius);
        this.height=height;
    }

    @Override
    public double getArea() {
        return 2*PI*radius*(radius+height);
    }

    public double getVolume(){
        return PI*radius*radius*height;
    }
}
