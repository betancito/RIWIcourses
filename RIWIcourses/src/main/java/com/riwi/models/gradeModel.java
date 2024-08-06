package com.riwi.models;

import com.riwi.entities.grade;
import com.riwi.persistence.configDB.MysqlConnection;
import com.riwi.persistence.imodel.iGrade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class gradeModel implements iGrade {
    @Override
    public grade create(grade request) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "INSERT INTO grade(grade, description, inscription_id) values(?,?,?);";

        //Instance grade to store generated info
        grade grade = new grade();

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            //set variables
            ps.setInt(1, request.getGrade());
            ps.setString(2, request.getDescription());
            ps.setInt(3,request.getInscription_id());

            //Execute
            ps.execute();

            //get Generated key
            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                grade.setId(rs.getInt(1));
                grade.setGrade(request.getGrade());
                grade.setDescription(request.getDescription());
                grade.setInscription_id(request.getInscription_id());
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return grade;
    }

    @Override
    public boolean delete(int id) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "DELETE FROM grade WHERE id=?;";

        //Instance boolean to check deletion
        boolean isDeleted = false;

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //set variables
            ps.setInt(1,id);

            //Execute
            int rs = ps.executeUpdate();

            //check if deletion was successful
            if (rs==1) {
                isDeleted=true;
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return isDeleted;
    }

    @Override
    public grade readByid(int id) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "SELECT * FROM grade WHERE id=?;";

        //Instance grade store outcome
        grade grade = null;

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //set variables
            ps.setInt(1,id);

            //Execute
            ps.execute();

            ResultSet rs = ps.getResultSet();

            //Get outcome and assign values to course

            while (rs.next()) {
                grade=new grade(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4));
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return grade;
    }

    @Override
    public boolean update(grade request) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "UPDATE grade SET grade = ?, description = ? WHERE id = ?;";

        //Instance isUpdated to store outcome
        boolean isUpdated = false;

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //set variables
            ps.setInt(1,request.getGrade());
            ps.setString(2,request.getDescription());
            ps.setInt(3,request.getId());

            //Execute and get int of how successful was the update
            int rs = ps.executeUpdate();

            //Get outcome and set isUpdated if successful

            if  (rs==1) {
                isUpdated=true;
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return isUpdated;
    }


    @Override
    public ArrayList<grade> readGradeByid(int id) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "SELECT * FROM grade WHERE inscription_id = ? ";

        //Instance grade to store outcome
        grade grade = null;

        //instance Arraylist to store grades
        ArrayList<grade> grades = new ArrayList<>();

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //replace values
            ps.setInt(1,id);

            //Execute
            ps.execute();

            ResultSet rs = ps.getResultSet();

            //Get outcome and assign values to stdent

            while (rs.next()) {
                grade = new grade(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4));
                grades.add(grade);
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return grades;
    }

    @Override
    public ArrayList<grade> read() {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "SELECT * FROM grade;";

        //Instance grade to store outcome
        grade grade = null;

        //instance Arraylist to store grades
        ArrayList<grade> grades = new ArrayList<>();

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //Execute
            ps.execute();

            ResultSet rs = ps.getResultSet();

            //Get outcome and assign values to grades arraylist

            while (rs.next()) {
                grade = new grade(rs.getInt(1),
                        rs.getInt(2),
                        rs.getString(3),
                        rs.getInt(4));
                grades.add(grade);
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return grades;
    }
}
