package com.example.ass2.model;

import android.widget.EditText;

public class CVinfo {

    private String name="";
    private String email="";
    private String hobbies="";
    private String phone="";
    private String Gender="";
    private String Eduction="";
    private String WorkExperience ;
    private String  Language;
    private String  Skill;

    public CVinfo()
    {

    }

    public CVinfo(String name, String email, String hobbies, String phone, String gender, String eduction, String workExperience, String language, String skill) {
        this.name = name;
        this.email = email;
        this.hobbies = hobbies;
        this.phone = phone;
        Gender = gender;
        Eduction = eduction;
        WorkExperience = workExperience;
        Language = language;
        Skill = skill;
    }

    public String getEduction() {
        return Eduction;
    }

    public void setEduction(String eduction) {
        Eduction = eduction;
    }

    public String getWorkExperience() {
        return WorkExperience;
    }

    public void setWorkExperience(String workExperience) {
        WorkExperience = workExperience;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getSkill() {
        return Skill;
    }

    public void setSkill(String skill) {
        Skill = skill;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getHobbies() {
        return hobbies;
    }

    public String getPhone() {
        return phone;
    }

    public String getGender() {
        return Gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setGender(String gender) {
        Gender = gender;
    }
}
