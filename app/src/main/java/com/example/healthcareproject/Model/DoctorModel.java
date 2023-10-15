package com.example.healthcareproject.Model;

public class DoctorModel {
    int doctorImg;
    String doctorDept;

    public int getDoctorImg() {
        return doctorImg;
    }

    public void setDoctorImg(int doctorImg) {
        this.doctorImg = doctorImg;
    }

    public String getDoctorDept() {
        return doctorDept;
    }

    public void setDoctorDept(String doctorDept) {
        this.doctorDept = doctorDept;
    }

    public DoctorModel(int doctorImg, String doctorDept) {
        this.doctorImg = doctorImg;
        this.doctorDept = doctorDept;
    }
}
