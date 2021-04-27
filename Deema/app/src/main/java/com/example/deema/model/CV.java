package com.example.deema.model;

public class CV {
    private String name;
    private String hobbies;
    private String email;
    private String gender;
    private String address;
    private String Education;
    private String Experience;
    private String skills;

    public CV(String name, String hobbies, String email, String gender, String address, String education, String experience, String skills) {
        this.name = name;
        this.hobbies = hobbies;
        this.email = email;
        this.gender = gender;
        this.address = address;
        Education = education;
        Experience = experience;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobbies() {
        return hobbies;
    }

    public void setHobbies(String hobbies) {
        this.hobbies = hobbies;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEducation() {
        return Education;
    }

    public void setEducation(String education) {
        Education = education;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String experience) {
        Experience = experience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }
}
