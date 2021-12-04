package Home.DAO;
import  Home.utilities.DBconnection;
import Home.model.student;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class studentdao
{

    Connection con=DBconnection.connect();
    PreparedStatement statement;
    String query;
    int result;

    public studentdao() throws SQLException, ClassNotFoundException {
    }

    public void createstudent(student studentobj) throws SQLException, ClassNotFoundException
    {

         query="INSERT INTO `student`( `name`, `address`, `phone`, `email`, `batchcode`, `gender`, `enrolnum`, `dob`) VALUES (?,?,?,?,?,?,?,?)";

        statement=con.prepareStatement(query);
        statement.setString(1,studentobj.getName());
        statement.setString(2,studentobj.getAddress());
        statement.setString(3,studentobj.getPhone());
        statement.setString(4,studentobj.getEmail());
        statement.setString(5,studentobj.getBatchcode());
        statement.setString(6,studentobj.getGender());
        statement.setString(7,studentobj.getEnrollnum());
        statement.setString(8,studentobj.getDob());

        result=statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"saved");
        }
        else
        {
            JOptionPane.showMessageDialog(null," not saved");

        }



    }

    public void updatestudent(student studentobj) throws SQLException {
        query="UPDATE `student` SET `name`=?,`address`=?,`phone`=?,`email`=?,`batchcode`=?,`gender`=?,`enrolnum`=?,`dob`=? WHERE `name`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,studentobj.getName());
        statement.setString(2,studentobj.getAddress());
        statement.setString(3,studentobj.getPhone());
        statement.setString(4,studentobj.getEmail());
        statement.setString(5,studentobj.getBatchcode());
        statement.setString(6,studentobj.getGender());
        statement.setString(7,studentobj.getEnrollnum());
        statement.setString(8,studentobj.getDob());
        statement.setString(9,studentobj.getName());
        result=statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null," not updated");

        }

    }


    public void deletestudent(student studentobj) throws SQLException {
        query="DELETE FROM `student` WHERE `name`=?";
        statement=con.prepareStatement(query);

        statement.setString(1,studentobj.getName());

        result=statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"deleted");
        }
        else
        {
            JOptionPane.showMessageDialog(null," not deleted");

        }
    }



}
