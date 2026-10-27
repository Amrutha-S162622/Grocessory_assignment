package com.example;

public class Patient extends Person {

    private String disease;
    private boolean premiumPatient;

    public Patient() {

    }

    public Patient(int id, String name, int age, String gender,
                   String phone, String disease, boolean premiumPatient) {

        super(id, name, age, gender, phone);
        this.disease = disease;
        this.premiumPatient = premiumPatient;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public boolean isPremiumPatient() {
        return premiumPatient;
    }

    public void setPremiumPatient(boolean premiumPatient) {
        this.premiumPatient = premiumPatient;
    }

    @Override
    public void displayDetails() {

        System.out.println("--------------------------------");

        System.out.println("Patient ID : " + getId());
        System.out.println("Name       : " + getName());
        System.out.println("Age        : " + getAge());
        System.out.println("Gender     : " + getGender());
        System.out.println("Phone      : " + getPhone());
        System.out.println("Disease    : " + disease);
        System.out.println("Premium    : " + premiumPatient);

    }

}