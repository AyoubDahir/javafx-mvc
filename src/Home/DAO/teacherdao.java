package Home.DAO;
import Home.model.Teacher;
import Home.utilities.*;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class teacherdao
{

    Teacher teacherobj = new Teacher();
    Connection con = DBconnection.connect();
    String query ;
    PreparedStatement statement;
    int result;

    public teacherdao() throws SQLException, ClassNotFoundException {
    }

    public void createTeacher(Teacher teacherobj) throws SQLException, ClassNotFoundException {
        query = "INSERT INTO `teacher`(`name`, `address`, `gender`, `subjectid`) VALUES (?,?,?,?)";
         statement = con.prepareStatement(query);
        statement.setString(1, teacherobj.getName());
        statement.setString(2, teacherobj.getAddress());
        statement.setString(3, teacherobj.getGender());
        statement.setString(4, teacherobj.getSubject());


        int result = statement.executeUpdate();
        if (result == 1){
            JOptionPane.showMessageDialog(null,"success");
        }else {
            JOptionPane.showMessageDialog(null,"failed");
        }

    }


    public void updateTeacher(Teacher teacherobj) throws SQLException {
        query="UPDATE `teacher` SET `name`=?,`address`=?,`gender`=?,`subjectid`=? WHERE `name`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,teacherobj.getName());
        statement.setString(2,teacherobj.getAddress());
        statement.setString(3,teacherobj.getGender());
        statement.setString(4,teacherobj.getSubject());
        statement.setString(5,teacherobj.getName());
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


    public void deleteTeacher(Teacher teacherob) throws SQLException {

        query="DELETE FROM `teacher` WHERE `name`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,teacherob.getName());
        result=statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showConfirmDialog(null,"deleted successfully");
        }
        else
        {
            JOptionPane.showConfirmDialog(null," not deleted");

        }

    }

}
