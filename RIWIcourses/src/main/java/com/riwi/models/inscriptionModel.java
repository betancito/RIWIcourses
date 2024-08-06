package com.riwi.models;

import com.riwi.entities.inscription;
import com.riwi.persistence.configDB.MysqlConnection;
import com.riwi.persistence.imodel.iInscription;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class inscriptionModel implements iInscription {
    @Override
    public inscription create(inscription request) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "INSERT INTO inscription(student_id, course_id) values(?,?);";

        //Instance inscription to store generated info
        inscription inscription = new inscription();

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            //set variables
            ps.setInt(1, request.getStudent_id());
            ps.setInt(2, request.getCourse_id());

            //Execute
            ps.execute();

            //get Generated key
            ResultSet rs = ps.getGeneratedKeys();

            while (rs.next()) {
                inscription.setId(rs.getInt(1));
                inscription.setStudent_id(request.getStudent_id());
                inscription.setCourse_id(request.getCourse_id());
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return inscription;
    }

    @Override
    public boolean delete(int id) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "DELETE FROM inscription WHERE id=?;";

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
    public inscription readByid(int id) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "SELECT * FROM inscription WHERE id=?;";

        //Instance inscription store outcome
        inscription inscription = null;

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
                inscription = new inscription(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3));
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return inscription;
    }

    @Override
    public boolean update(inscription request) {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "UPDATE inscription SET student_id = ?, course_id = ? WHERE id = ?;";

        //Instance isUpdated to store outcome
        boolean isUpdated = false;

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //set variables
            ps.setInt(1,request.getStudent_id());
            ps.setInt(2,request.getCourse_id());
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
    public ArrayList<inscription> read() {
        //Open connection
        Connection connection = MysqlConnection.openConnection();

        //Set query to replace values
        String sqlQuery = "SELECT * FROM inscription";

        //Instance INSCRIPTION to store outcome
        inscription inscription = null;

        //instance Arraylist to store inscriptions
        ArrayList<inscription> inscriptions = new ArrayList<>();

        //Prepare query to be injected
        try {
            //prepare to replace "?" values
            PreparedStatement ps = connection.prepareStatement(sqlQuery);

            //Execute
            ps.execute();

            ResultSet rs = ps.getResultSet();

            //Get outcome and assign values to stdent

            while (rs.next()) {
                inscription = new inscription(rs.getInt(1),
                        rs.getInt(2),
                        rs.getInt(3));
                inscriptions.add(inscription);
            }
            //close query
            ps.close();
        }catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //close connection with db
            MysqlConnection.closeConnection();
        }
        return inscriptions;
    }

}
