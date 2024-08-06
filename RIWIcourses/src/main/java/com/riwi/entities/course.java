package com.riwi.entities;

public class course {
    private int id;
    private String courseName;
    private String courseDescription;

    //Constructors
    public course() {}
    public course(int id, String courseName, String courseDescription) {
        this.id = id;
        this.courseName = courseName;
        this.courseDescription = courseDescription;
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    //Getters
    public int getId() {
        return id;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    //toString

    @Override
    public String toString() {
        return "||course: " + " ||id=" + id + " ||courseName=" + courseName + " ||courseDescription=" + courseDescription + "\n";
    }
}
