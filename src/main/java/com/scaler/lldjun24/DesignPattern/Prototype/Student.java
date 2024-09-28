package com.scaler.lldjun24.DesignPattern.Prototype;

public class Student implements Prototype<Student>{
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getPsp() {
        return psp;
    }

    public void setPsp(double psp) {
        this.psp = psp;
    }

    public double getAvgpsp() {
        return avgpsp;
    }

    public void setAvgpsp(double avgpsp) {
        this.avgpsp = avgpsp;
    }

    public String getBatchname() {
        return batchname;
    }

    public void setBatchname(String batchname) {
        this.batchname = batchname;
    }

    private String name;
    private int age;
    private double psp;
    private double avgpsp;
    private String batchname;

    @Override
    public Student clone() {
        Student clone = new Student();
        clone.name = this.name;
        clone.age = this.age;
        clone.psp = this.psp;
        clone.avgpsp = this.avgpsp;
        clone.batchname = this.batchname;
        return clone;
    }
}
