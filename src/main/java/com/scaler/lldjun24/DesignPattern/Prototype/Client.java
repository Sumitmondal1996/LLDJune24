package com.scaler.lldjun24.DesignPattern.Prototype;

public class Client {
    public static void main(String[] args) {
        StudentRegistry sr = new StudentRegistry();
        fillregistry(sr);
        Student sumit = sr.get("Aug2024").clone();
        sumit.setName("Sumit");
        sumit.setPsp(89.0);

        Student amit = sr.get("Aug2024_int").clone();
        amit.setName("Amit");
        amit.setPsp(99.0);

        System.out.println("DEBUG");

    }
    public static void fillregistry(StudentRegistry sr)
    {

        Student student = new Student();
        student.setBatchname("Aug2024");
        student.setAvgpsp(90.0);
        sr.register("Aug2024", student);

        Student int_student = new IntelligentStudent();
        int_student.setBatchname("Aug2024_int");
        int_student.setAvgpsp(90.0);
        sr.register("Aug2024_int", int_student);
    }
}
