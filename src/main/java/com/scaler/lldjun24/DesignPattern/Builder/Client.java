package com.scaler.lldjun24.DesignPattern.Builder;

public class Client {
    public static void main(String[] args) {

//        Builder b = Student.getBuilder();
//        b.setAge(20);
//        b.setName("Akash");
//        b.setPsp(90.0);
//        b.setEmail("xyz@com");
//        b.setUnivName("ABC");
//        Student st= b.build();

        Student st = Student.getBuilder()
                .setName("Akash")
                .setAge(20)
                .setpsp(90.0)
                .setEmail("xyz@com")
                .setUnivName("ABC")
                .build();

        System.out.println("DEBUG");


    }
}
