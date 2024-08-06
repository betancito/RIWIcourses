package com.riwi.entities;

public class inscription {
    private int id;
    private int student_id;
    private int course_id;

    //Constructors
    public inscription() {
    }
    public inscription(int id, int student_id, int course_id) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
    }

    //Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    //Getters
    public int getId() {
        return id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    //toString

    @Override
    public String toString() {
        return "||inscription: " + " ||id=" + id + " ||student_id=" + student_id + " ||course_id=" + course_id + "\n";
    }
}
