package com.riwi.controllers;

import com.riwi.entities.course;
import com.riwi.models.courseModel;
import com.riwi.persistence.imodel.iCourse;

import javax.swing.*;
import java.util.ArrayList;

public class courseController {
    public static ArrayList<course> readAll(){
        iCourse course = new courseModel();
        return course.read();
    }
    //Create logic for course
    public static course create(){
        iCourse course = new courseModel();
        boolean isNameRepeated = false;
        String courseName = JOptionPane.showInputDialog("Provide the name of the course");
        String courseDescription = JOptionPane.showInputDialog("Provide the description of the course");
        course course1 = new course();
        course1.setCourseName(courseName);
        course1.setCourseDescription(courseDescription);
        ArrayList<course> courses = courseController.readAll();
        for ( course c : courses) {
            String name = c.getCourseName();
            if (name.equalsIgnoreCase(courseName)){
                isNameRepeated=true;
            }
        }
        if (isNameRepeated){
            return null;
        } else {
            return course.create(course1);
        }
    }
    //Delete logic for course
    public static String delete(){
        iCourse course = new courseModel();
        boolean outcome = false;
        int op = Integer.parseInt(JOptionPane.showInputDialog("Remember that if you delete a course you'll delete the grades of the students attached to it do you agree? 1=yes 2=no"));
        switch (op){
            case 1:
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the course to be deleted"));
                outcome = course.delete(id);
                break;
            case 2:
                outcome = false;
                break;
        }
        if (outcome){
            return "Course successfully deleted";
        }else {
            return "Course didn't deleted";
        }
    }

    //Read by id logic for course
    public static course readByid(){
        iCourse course = new courseModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the course to be searched"));
        return course.readByid(id);
    }

    //Update logic for course
    public static String update(){
        iCourse course = new courseModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the course to be updated"));
        String name = JOptionPane.showInputDialog("Enter the updated name of the ourse");
        String description = JOptionPane.showInputDialog("Enter the updted description of the course");
        course course1 = new course(id,name,description);
        boolean outcome = course.update(course1);
        if (outcome){
            return "Course successfully updated";
        }else {
            return "Course couldn't be updated";
        }
    }


}
