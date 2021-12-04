package Home.DAO;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import Home.model.*;

import Home.utilities.*;

import javax.swing.*;

public class userDAO
{
    Connection con=DBconnection.connect();
    user userobj=new user();


    public userDAO() throws SQLException, ClassNotFoundException {
    }

    public void createuser(user userobj) throws SQLException, ClassNotFoundException
    {
        String query="INSERT INTO `user`(`username`, `passowrd`) VALUES (?,?)";
        PreparedStatement statement=con.prepareStatement(query);
        statement.setString(1, userobj.getUsername());
        statement.setString(2, userobj.getPassword());
        int result=statement.executeUpdate();
        if(result==1)
        {
            JOptionPane.showMessageDialog(null,"user created");
        }
        else
        {
            JOptionPane.showMessageDialog(null,"user not created");

        }



    }

    public void selectuser(user userobj) throws SQLException, IOException {
        String query="SELECT `username`, `passowrd` FROM `user` WHERE `username`=? AND `passowrd`=?";
      PreparedStatement statement=con.prepareStatement(query);
      statement.setString(1, userobj.getUsername());
      statement.setString(2, userobj.getPassword());
        ResultSet st=statement.executeQuery();

        if(st.next())
        {
            JOptionPane.showConfirmDialog(null,"correct username welcome");
            url obj=new url();
            obj.show("dashboard","/Home/view/dashboard.fxml");

        }
        else
        {
            JOptionPane.showMessageDialog(null,"incorrect username or password");

        }


    }

}
