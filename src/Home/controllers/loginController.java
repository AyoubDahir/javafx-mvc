package Home.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Home.utilities.*;
import Home.model.user;
import Home.DAO.*;
import javax.swing.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class loginController
{
    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnlogin;

    @FXML
    void login(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        user userobj=new user();
        userobj.setUsername(txtusername.getText());
        userobj.setPassword(txtpassword.getText());

        userDAO userDAOobj=new userDAO();
        userDAOobj.selectuser(userobj);





    }

    @FXML
    void showSignin(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("signup","/Home/view/signup.fxml");


    }
}
