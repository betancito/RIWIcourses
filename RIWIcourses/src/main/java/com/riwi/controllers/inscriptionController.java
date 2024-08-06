package com.riwi.controllers;

import com.riwi.entities.inscription;
import com.riwi.models.inscriptionModel;
import com.riwi.persistence.imodel.iInscription;

import javax.swing.*;
import java.util.ArrayList;

public class inscriptionController {
    //read all logic for inscription
    public static ArrayList<inscription> readAll(){
        iInscription inscription = new inscriptionModel();
        return inscription.read();
    }
    //Create logic for inscription
    public static String create(){
        iInscription inscription = new inscriptionModel();
        inscription inscription1 = new inscription();
        int student_id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the student to be signed up"));
        int course_id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the course the student is going to be signed up to"));
        inscription1.setStudent_id(student_id);
        inscription1.setCourse_id(course_id);
        ArrayList <inscription> inscriptions = inscriptionController.readAll();
        int studentCount = 0;
        for (inscription i:inscriptions) {
            int studentId = i.getStudent_id();
            if (studentId==student_id){
                studentCount++;
            }
        }
        if (studentCount>=3){
            return "Couldn't make inscription student is already signed up to 3 courses";
        }else {
            inscription.create(inscription1);
            return "Student sucessfully signed up";
        }
    }
    //Delete logic for inscription
    public static String delete(){
        iInscription inscription = new inscriptionModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the inscription to be deleted"));
        boolean isDeleted = inscription.delete(id);
        if (!isDeleted){
            return "Inscription wasn't deleted please try again";
        }else {
            return "Inscription successfully deleted";
        }
    }
    //Update logic for inscription
    public static String update(){
        iInscription inscription = new inscriptionModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the inscription to be updated"));
        int student_id = Integer.parseInt(JOptionPane.showInputDialog("Enter the new student id"));
        int course_id = Integer.parseInt(JOptionPane.showInputDialog("Enter the new course id"));
        inscription inscription1 = new inscription(id,student_id,course_id);
        boolean isUpdated = inscription.update(inscription1);
        if (!isUpdated){
            return "The update failed. Please try again";
        }else{
            return "The inscription was successfully made";
        }
    }
    //Read by id logic for inscription
    public static inscription readByid(){
        iInscription inscription = new inscriptionModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the id of the inscription to be searched"));
        return inscription.readByid(id);
    }
}
