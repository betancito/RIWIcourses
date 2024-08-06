package com.riwi.models;

import com.riwi.entities.grade;
import com.riwi.entities.student;
import com.riwi.persistence.configDB.MysqlConnection;
import com.riwi.persistence.imodel.iStudent;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class studentModel implements iStudent {
    @Override
    public student create(student request) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "INSERT INTO student(name, lastName, email, active) values(?,?,?,?);";

        //Instance student to store generated info
        student student = new student();

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            //set variables
            ps.setString(1, request.getName());
            ps.setString(2, request.getLastName());
            ps.setString(3, request.getEmail());
            ps.setBoolean(4,request.isActive());

            //Execute
            ps.execute();

            //get Generated key
            ResultSet rs = ps.getGeneratedKeys();
            while (rs.next()) {
                student.setId(rs.getInt(1));
                student.setName(request.getName());
                student.setLastName(request.getLastName());
                student.setEmail(request.getEmail());
                student.setActive(request.isActive());
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return student;
    }

    @Override
    public boolean delete(int id) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "DELETE FROM student WHERE id=?;";

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
    public student readByid(int id) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "SELECT * FROM student WHERE id=?;";

        //Instance STUDENT to store outcome
        student student = null;

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //set variables
            ps.setInt(1,id);

            //Execute
            ps.execute();

            ResultSet rs = ps.getResultSet();

            //Get outcome and assign values to stdent

            while (rs.next()) {
                student = new student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getBoolean("active"));
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return student;
    }

    @Override
    public ArrayList<student> read() {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "SELECT * FROM student";

        //Instance STUDENT to store outcome
        student student = null;

        //instance Arraylist to store students
        ArrayList<student> students = new ArrayList<>();

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //Execute
            ps.execute();

            ResultSet rs = ps.getResultSet();

            //Get outcome and assign values to stdent

            while (rs.next()) {
                student = new student(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("lastName"),
                        rs.getString("email"),
                        rs.getBoolean("active"));
                students.add(student);
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return students;
    }

    @Override
    public boolean update(student request) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "UPDATE student SET name = ?, lastName = ?, email = ?, active = ? WHERE id = ?;";

        //Instance isUpdated to store outcome
        boolean isUpdated = false;

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //set variables
            ps.setString(1, request.getName());
            ps.setString(2,request.getLastName());
            ps.setString(3,request.getEmail());
            ps.setBoolean(4,request.isActive());
            ps.setInt(5, request.getId());

            //Execute and get int of how successful was the update
            int rs = ps.executeUpdate();

            //Get outcome and set isUpdated if successful

            if  (rs==1) {
                isUpdated=true;
            }
            //cerrar query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return isUpdated;
    }
}
