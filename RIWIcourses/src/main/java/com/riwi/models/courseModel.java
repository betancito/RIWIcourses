package com.riwi.models;

import com.riwi.entities.course;
import com.riwi.persistence.configDB.MysqlConnection;
import com.riwi.persistence.imodel.iCourse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class courseModel implements iCourse {
    @Override
    public course create(course request) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "INSERT INTO course(courseName, courseDescription) values(?,?);";

        //Instance course to store generated info
        course course = new course();

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            //set variables
            ps.setString(1, request.getCourseName());
            ps.setString(2, request.getCourseDescription());

            //Execute
            ps.execute();

            //get Generated key
            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                course.setId(rs.getInt(1));
                course.setCourseName(request.getCourseName());
                course.setCourseDescription(request.getCourseDescription());
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return course;
    }

    @Override
    public boolean delete(int id) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "DELETE FROM course WHERE id=?;";

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
    public course readByid(int id) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "SELECT * FROM course WHERE id=?;";

        //Instance course store outcome
        course course = null;

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //set variables
            ps.setInt(1,id);

            //Execute
            ps.execute();

            //Result set to get registers from DB
            ResultSet rs = ps.getResultSet();

            //Get outcome and assign values to course
            while (rs.next()) {
                course = new course(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return course;
    }

    @Override
    public boolean update(course request) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "UPDATE course SET courseName = ?, courseDescription = ? WHERE id = ?;";

        //Instance isUpdated to store outcome
        boolean isUpdated = false;

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //set variables
            ps.setString(1,request.getCourseName());
            ps.setString(2,request.getCourseDescription());
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
    public ArrayList<course> read() {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "SELECT * FROM course";

        //Instance COURSE to store outcome
        course course = null;

        //instance Arraylist to store courses
        ArrayList<course> courses = new ArrayList<>();

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //Execute
            ps.execute();

            ResultSet rs = ps.getResultSet();

            //Get outcome and assign values to course

            while (rs.next()) {
                course = new course(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3));
                courses.add(course);
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return courses;
    }
}
