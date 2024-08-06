package com.riwi.entities;

public class grade {
    private int id;
    private int grade;
    private String description;
    private int inscription_id;

    //Constructor
    public grade() {
    }
    public grade(int id, int grade, String description, int inscription_id) {
        this.id = id;
        this.grade = grade;
        this.description = description;
        this.inscription_id = inscription_id;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setInscription_id(int inscription_id) {
        this.inscription_id = inscription_id;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getGrade() {
        return grade;
    }

    public String getDescription() {
        return description;
    }

    public int getInscription_id() {
        return inscription_id;
    }

    //toString

    @Override
    public String toString() {
        return "||grade: " + " ||id=" + id + " ||grade=" + grade + " ||description=" + description + " ||inscription_id=" + inscription_id + "\n";
    }
}
