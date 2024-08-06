package com.riwi.entities;

public class student {
    private int id;
    private String name;
    private String lastName;
    private String email;

    private boolean active;

    //Constructors
    public student(){}

    public student(int id, String name, String lastName, String email, boolean active) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
    }


    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


    //getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public boolean isActive() {
        return active;
    }

    //toString

    @Override
    public String toString() {
        return "||student: " + " ||id=" + id + " ||name=" + name + " ||lastName=" + lastName + " ||email=" + email + " ||active=" + active + "\n";
    }
}
