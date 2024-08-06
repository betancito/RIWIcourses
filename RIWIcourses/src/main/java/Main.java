import com.riwi.controllers.courseController;
import com.riwi.controllers.gradeController;
import com.riwi.controllers.inscriptionController;
import com.riwi.controllers.studentController;
import com.riwi.entities.course;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        boolean cond = false;
        while (!cond) {
            int op = Integer.parseInt(JOptionPane.showInputDialog("Hello and welcome to the RIWI managment app\n Next up select what you want to work on today" +
                    "\n1. Student" +
                    "\n2. Course" +
                    "\n3. Inscription" +
                    "\n4. Grade" +
                    "\n5. exit"));
            switch (op){
                case 1:
                    //Prompt for user to choose what they want to do with the students table
                    int op1 = Integer.parseInt(JOptionPane.showInputDialog("Please select what you want to do with Students" +
                            "\n1. Create Student" +
                            "\n2. Delete a Student" +
                            "\n3. Update a student" +
                            "\n4. Find a Student by id" +
                            "\n5. Show full student list" +
                            "\n6. Return to main Menu"));
                    switch (op1){
                        case 1:
                            JOptionPane.showMessageDialog(null,studentController.create());
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null,studentController.delete());
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null,studentController.update());
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null,studentController.readByid());
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, studentController.readAll());
                            break;
                        case 6:
                            break;
                    }
                    break;

                case 2:
                    //Prompt for user to choose what they want to do with Courses table
                    int op2 = Integer.parseInt(JOptionPane.showInputDialog("Please select what you want to do with Courses" +
                            "\n1. Create Course" +
                            "\n2. Delete a Course" +
                            "\n3. Update a Course" +
                            "\n4. Find a Course by id" +
                            "\n5. Show full Courses list" +
                            "\n6. Return to main Menu"));
                    switch (op2){
                        case 1:
                            course course = courseController.create();
                            if (course==null){
                                JOptionPane.showMessageDialog(null, "The course couldn't be created because there's another course under the same name");
                            } else {
                                JOptionPane.showMessageDialog(null,course);
                            }
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null,courseController.delete());
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null,courseController.update());
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null,courseController.readByid());
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, courseController.readAll());
                            break;
                        case 6:
                            break;
                    }
                    break;
                case 3:
                    //Prompt for user to choose what they want to do with the students table
                    int op3 = Integer.parseInt(JOptionPane.showInputDialog("Please select what you want to do with Inscriptions" +
                            "\n1. Create an Inscription" +
                            "\n2. Delete an Inscription" +
                            "\n3. Update an Inscription" +
                            "\n4. Find an Inscription by id" +
                            "\n5. Show full Inscriptions list" +
                            "\n6. Return to main Menu"));
                    switch (op3){
                        case 1:
                            JOptionPane.showMessageDialog(null,inscriptionController.create());
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null,inscriptionController.delete());
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null,inscriptionController.update());
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null,inscriptionController.readByid());
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, inscriptionController.readAll());
                            break;
                        case 6:
                            break;
                    }
                    break;
                case 4:
                    //Prompt for user to choose what they want to do with the students table
                    int op4 = Integer.parseInt(JOptionPane.showInputDialog("Please select what you want to do with Grades" +
                            "\n1. Create a grade" +
                            "\n2. Delete a grade" +
                            "\n3. Update a grade" +
                            "\n4. Find a grade by id" +
                            "\n5. Show full grades list" +
                            "\n6. Show all grades by inscription id" +
                            "\n7. Exit to main menu"));
                    switch (op4){
                        case 1:
                            JOptionPane.showMessageDialog(null,gradeController.create());
                            break;
                        case 2:
                            JOptionPane.showMessageDialog(null,gradeController.delete());
                            break;
                        case 3:
                            JOptionPane.showMessageDialog(null,gradeController.update());
                            break;
                        case 4:
                            JOptionPane.showMessageDialog(null,gradeController.readByid());
                            break;
                        case 5:
                            JOptionPane.showMessageDialog(null, gradeController.readAll());
                            break;
                        case 6:
                            JOptionPane.showMessageDialog(null, gradeController.readAllGrades());
                            break;
                        case 7:
                            break;
                    }
                    break;
                case 5:
                    cond = true;
                    break;
            }
        }
    }
}