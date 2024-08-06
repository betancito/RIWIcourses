package com.riwi.controllers;

import com.riwi.models.studentModel;
import com.riwi.persistence.imodel.iStudent;
import com.riwi.entities.student;

import javax.swing.*;
import java.util.ArrayList;

public class studentController {
    //Create logic for student
    public static student create(){
        iStudent student = new studentModel();
        String name = JOptionPane.showInputDialog("Enter the name of the student");
        String lastName = JOptionPane.showInputDialog("Enter the last name of the Student");
        String email = JOptionPane.showInputDialog("Enter the email of the student");
        String active = JOptionPane.showInputDialog("Is the student active? (TYPE YES/NO)");
        student student1 = new student();
        student1.setName(name);
        student1.setLastName(lastName);
        student1.setEmail(email);
        if (active.equalsIgnoreCase("YES")){
            student1.setActive(true);
        }else if (active.equalsIgnoreCase("NO")) {
            student1.setActive(false);
        }
        return student.create(student1);
    }
    //Delete logic for student
    public static String delete(){
        iStudent student = new studentModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Please provide the ID of the student to be deleted\nremember all grades that are attached to the student will be deleted as well"));
        boolean result = student.delete(id);
        String prompt = null;
        if (result){
            prompt = "Student with id " + id + " was deleted sucessfully";
        } else if (!result) {
            prompt = "Unable to delete, invalid id";
        }
        return prompt;
    }
    //Read by id logic for student
    public static student readByid(){
        iStudent student = new studentModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Please provide the id of the student to be searched"));
        return student.readByid(id);
    }
    //Update logic for student
    public static String update(){
        iStudent student = new studentModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the student to be updated"));
        String name = JOptionPane.showInputDialog("Enter the updated name of the student");
        String lastName = JOptionPane.showInputDialog("Enter the updated last name of the Student");
        String email = JOptionPane.showInputDialog("Enter the updated email of the student");
        String active = JOptionPane.showInputDialog("Is the updated student status (TYPE YES/NO)");
        student student1 = new student();
        student1.setId(id);
        student1.setName(name);
        student1.setLastName(lastName);
        student1.setEmail(email);
        if (active.equalsIgnoreCase("YES")){
            student1.setActive(true);
        }else if (active.equalsIgnoreCase("NO")) {
            student1.setActive(false);
        }
        boolean outcome = student.update(student1);
        String prompt = null;
        if (outcome){
            prompt = "Student successfully updated";
        } else if (!outcome) {
            prompt ="Student couldn't be updated please try again";
        }
        return prompt;
    }
    //Read all logic for student
    public static ArrayList<student> readAll(){
        iStudent student = new studentModel();
        return student.read();
    }
}
