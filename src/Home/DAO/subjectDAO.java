package Home.DAO;

import Home.utilities.DBconnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import Home.model.subject;

import javax.swing.*;

public class subjectDAO
{
    Connection con= DBconnection.connect();
    PreparedStatement statement;
    String query;
    int result;

    public subjectDAO() throws SQLException, ClassNotFoundException {
    }

    public void createsubject(subject subjectobj) throws SQLException {
        query="INSERT INTO `subject`(`code`, `name`) VALUES (?,?)";
        statement=con.prepareStatement(query);
        statement.setString(1,subjectobj.getSubjectname());

        statement.setString(2,subjectobj.getCode());
        result=statement.executeUpdate();


        if (result==1)
        {
            JOptionPane.showConfirmDialog(null,"subject created");
        }
        else
        {
            JOptionPane.showConfirmDialog(null," not saved");

        }


    }


    public void updatesubject(subject subjectobj) throws SQLException {
        query="UPDATE `subject` SET `code`=?,`name`=? WHERE `code`=?";
        statement=con.prepareStatement(query);

        statement.setString(1,subjectobj.getCode());
        statement.setString(2,subjectobj.getSubjectname());
        statement.setString(3,subjectobj.getCode());
        result=statement.executeUpdate();


        if (result==1)
        {
            JOptionPane.showConfirmDialog(null,"updated created");
        }
        else
        {
            JOptionPane.showConfirmDialog(null," not updated");

        }

    }

    public void deletesubject(subject subjectobj) throws SQLException {
        query="DELETE FROM `subject` WHERE `name`=?";
        statement=con.prepareStatement(query);

        statement.setString(1,subjectobj.getSubjectname());

        result=statement.executeUpdate();


        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"subject deleted");
        }
        else
        {
            JOptionPane.showMessageDialog(null," not deleted");

        }

    }
}
