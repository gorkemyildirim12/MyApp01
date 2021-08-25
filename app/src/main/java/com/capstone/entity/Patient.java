package com.capstone.entity;

import java.io.Serializable;

public class Patient implements Serializable {
    private long patientId;
    private String patientName;
    private String patientSurname;
    private String patientGender;
    private String email;
    private int patientAge;
    private double patientHeight;
    private double patientWeight;
    private int shoeNumber;

    public Patient(long patientId, String patientName, String patientSurname,
                   String patientGender, String email,
                   int patientAge, double patientHeight, double patientWeight, int shoeNumber) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.patientGender = patientGender;
        this.email = email;
        this.patientAge = patientAge;
        this.patientHeight = patientHeight;
        this.patientWeight = patientWeight;
        this.shoeNumber = shoeNumber;
    }


    public Patient() {
    }


    public long getPatientId() {
        return patientId;
    }

    public void setPatientId(long patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getPatientGender() {
        return patientGender;
    }

    public void setPatientGender(String patientGender) {
        this.patientGender = patientGender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPatientAge() {
        return patientAge;
    }

    public void setPatientAge(int patientAge) {
        this.patientAge = patientAge;
    }

    public double getPatientHeight() {
        return patientHeight;
    }

    public void setPatientHeight(double patientHeight) {
        this.patientHeight = patientHeight;
    }

    public double getPatientWeight() {
        return patientWeight;
    }

    public void setPatientWeight(double patientWeight) {
        this.patientWeight = patientWeight;
    }

    public int getShoeNumber() {
        return shoeNumber;
    }

    public void setShoeNumber(int shoeNumber) {
        this.shoeNumber = shoeNumber;
    }

    public String fullName(){
        return patientName + " " + patientSurname;
    }
}
