package Home.controllers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import Home.model.*;
import Home.DAO.*;

import java.sql.SQLException;


public class signupController
{


    @FXML
    private TextField txtusername;

    @FXML
    private PasswordField txtpassword;

    @FXML
    private Button btnsave;

    @FXML
    void save(ActionEvent event) throws SQLException, ClassNotFoundException {
            String username=txtusername.getText();
            String password=txtpassword.getText();

            user userobj=new user();
            userobj.setUsername(username);
            userobj.setPassword(password);


            userDAO userDAOobj=new userDAO();
            userDAOobj.createuser(userobj);
        //txtusername.getScene().getWindow().hide();





    }
}
