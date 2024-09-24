package com.scaler.lldjun24.DesignPattern.Builder;

public class Student {
    private String name;
    private int age;
    private double psp;
    private String univName;
    private String email;

    private Student(Builder builder)
    {
        this.name = builder.getName();
        this.age = builder.getAge();
        this.psp = builder.getpsp();
        this.univName = builder.getUnivName();
        this.email = builder.getEmail();

    }
    public static Builder getBuilder()
    {
        return new Builder();
    }
    public static class Builder {
        private String name;
        private int age;
        private double psp;
        private String univName;
        private String email;


        public String getName() {
            return name;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public double getpsp() {
            return psp;
        }

        public Builder setpsp(double psp) {
            this.psp = psp;
            return this;
        }

        public String getUnivName() {
            return univName;
        }

        public Builder setUnivName(String univName) {
            this.univName = univName;
            return this;
        }

        public int getAge() {
            return age;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public String getEmail() {
            return email;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Student build()
        {
            if(this.age<20)
            {
                throw new RuntimeException("Age not satisfied");
            }
            return new Student(this);
        }


    }

}
