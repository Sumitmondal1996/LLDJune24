package com.scaler.lldjun24.DesignPattern.Prototype;

public class IntelligentStudent extends Student{
    private double iq;
    public IntelligentStudent clone() {
        IntelligentStudent is = new IntelligentStudent();
        is.setName(this.getName());
        is.setAge(this.getAge());
        is.setPsp(this.getPsp());
        is.setAvgpsp(this.getAvgpsp());
        is.iq= this.iq;
        return is;
    }
}
