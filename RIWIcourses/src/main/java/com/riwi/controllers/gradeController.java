package com.riwi.controllers;

import com.riwi.entities.grade;
import com.riwi.models.gradeModel;
import com.riwi.persistence.imodel.iGrade;

import javax.swing.*;
import java.util.ArrayList;

public class gradeController {
    //Create logic for grade
    public static grade create(){
        iGrade grade = new gradeModel();
        grade grade1 = new grade();
        int inscription_id = Integer.parseInt(JOptionPane.showInputDialog("Enter the inscription id of the student to be graded"));
        int grade2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the grade"));
        String gradeDescription = JOptionPane.showInputDialog("Enter the grade description");
        grade1.setGrade(grade2);
        grade1.setInscription_id(inscription_id);
        grade1.setDescription(gradeDescription);
        return grade.create(grade1);
    }
    //Delete logic for grade
    public static String delete(){
        iGrade grade = new gradeModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the ID of the grade to be deleted"));
        boolean isDeleted = grade.delete(id);
        if (!isDeleted){
            return "Couldn't delete grade. Please try again";
        }else {
            return "Grade successfully deleted";
        }
    }
    //Read by id logic for grade
    public static grade readByid(){
        iGrade grade = new gradeModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Please enter the id of the grade to be searched"));
        return grade.readByid(id);
    }
    //Update logic for grade
    public static String update(){
        iGrade grade = new gradeModel();
        grade grade1 = new grade();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the name of the grade to be updated"));
        int grade2 = Integer.parseInt(JOptionPane.showInputDialog("Enter the updated grade"));
        String description = JOptionPane.showInputDialog("Enter the updated description");
        grade1.setId(id);
        grade1.setGrade(grade2);
        grade1.setDescription(description);
        boolean isUpdated = grade.update(grade1);
        if (!isUpdated){
            return "Grade couldn't be updated";
        }else {
            return "Grade successfully updated";
        }
    }
    //Read All logic for grade
    public static ArrayList<grade> readAll(){
        iGrade grade = new gradeModel();
        return grade.read();
    }
    //Read all logic for grades by using the inscription id
    public static ArrayList<grade> readAllGrades(){
        iGrade grade = new gradeModel();
        int id = Integer.parseInt(JOptionPane.showInputDialog("Enter the inscription id of the student you want to see the grades for"));
        return grade.readGradeByid(id);
    }
}
