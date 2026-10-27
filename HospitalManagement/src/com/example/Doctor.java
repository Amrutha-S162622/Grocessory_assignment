package com.example;

public class Doctor extends Person {

    private String specialization;
    private double consultationFee;
    private int experience;

    public Doctor() {

    }

    public Doctor(int id, String name, int age,
                  String gender, String phone,
                  String specialization,
                  double consultationFee,
                  int experience) {

        super(id, name, age, gender, phone);

        this.specialization = specialization;
        this.consultationFee = consultationFee;
        this.experience = experience;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public double getConsultationFee() {
        return consultationFee;
    }

    public void setConsultationFee(double consultationFee) {
        this.consultationFee = consultationFee;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public void displayDetails() {

        System.out.println("--------------------------------");

        System.out.println("Doctor ID      : " + getId());
        System.out.println("Name           : " + getName());
        System.out.println("Age            : " + getAge());
        System.out.println("Gender         : " + getGender());
        System.out.println("Phone          : " + getPhone());
        System.out.println("Specialization : " + specialization);
        System.out.println("Experience     : " + experience + " Years");
        System.out.println("Fee            : ₹" + consultationFee);

    }

}
