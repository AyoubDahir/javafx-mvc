package Home.DAO;

import Home.model.Attendence;
import Home.utilities.DBconnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class attendencedao
{
    Connection con= DBconnection.connect();
    PreparedStatement statement;
    String query;
    int result;

    public attendencedao() throws SQLException, ClassNotFoundException {
    }

    public void createattendance(Attendence attendenceobj) throws SQLException {
        query="INSERT INTO `attendance`(`date`, `studentid`, `subjectid`, `statue`) VALUES (?,?,?,?)";
        statement=con.prepareStatement(query);
        statement.setString(1,attendenceobj.getDate());
        statement.setString(2,attendenceobj.getStudentid());
        statement.setString(3,attendenceobj.getSubjectid());
        statement.setString(4,attendenceobj.getStatus());
        result=statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"attendances created");
        }
        else
        {
            JOptionPane.showMessageDialog(null," attendance not added ");

        }



    }

    public void updateattendance(Attendence attendenceobj) throws SQLException {
        query="UPDATE `attendance` SET `date`=?,`studentid`=?,`subjectid`=?,`statue`=? WHERE `studentid`=? and date=?";
        statement=con.prepareStatement(query);
        statement.setString(1,attendenceobj.getDate());
        statement.setString(2,attendenceobj.getStudentid());
        statement.setString(3,attendenceobj.getSubjectid());
        statement.setString(4,attendenceobj.getStatus());
        statement.setString(5,attendenceobj.getStudentid());
        statement.setString(6,attendenceobj.getDate());

        result=statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"attendances not updated");
        }
        else
        {
            JOptionPane.showMessageDialog(null," attendance  updated ");

        }
    }

    public void deletAttendance(Attendence attendenceobj) throws SQLException {
        query="DELETE FROM `attendance` WHERE `studentid`=?";
        statement=con.prepareStatement(query);
        statement.setString(1,attendenceobj.getStudentid());
        result=statement.executeUpdate();

        if (result==1)
        {
            JOptionPane.showMessageDialog(null,"attendances deleted");
        }
        else
        {
            JOptionPane.showMessageDialog(null," attendance  not delted ");

        }

    }


}
