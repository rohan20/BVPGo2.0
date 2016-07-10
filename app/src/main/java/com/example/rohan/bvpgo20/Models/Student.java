package com.example.rohan.bvpgo20.Models;

/**
 * Created by Rohan on 09-May-16.
 */
public class Student {

    String email;
    String name;
    String mobileNumber;
    String rollNumber;
    String branch;
    String semester;

    public Student() {
    }

    public Student(String email, String name, String mobileNumber, String rollNumber, String branch, String semester) {
        this.email = email;
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.rollNumber = rollNumber;
        this.branch = branch;
        this.semester = semester;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getRollNumber() {
        return rollNumber;
    }

    public String getBranch() {
        return branch;
    }

    public String getSemester() {
        return semester;
    }
}
