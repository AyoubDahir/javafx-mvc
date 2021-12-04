package Home.controllers;
import Home.utilities.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import Home.model.*;
import Home.DAO.studentdao;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class studentController implements Initializable
{

    @FXML
    private TextField txtdob;

    @FXML
    private TextField txtname;

    @FXML
    private TextField txtphone;

    @FXML
    private TextField txtemail;

    @FXML
    private TextField txtenroll;

    @FXML
    private ComboBox<String> comboaddress;

    @FXML
    private ComboBox<String> combogender;

    @FXML
    private ComboBox<String> combobatch;

    @FXML
    private Button btnsave;
    @FXML
    private TableView<student> studentTable;

    @FXML
    private TableColumn<student, String> colname;

    @FXML
    private TableColumn<student, String> coladdress;

    @FXML
    private TableColumn<student, String> colphone;

    @FXML
    private TableColumn<student, String> colemail;

    @FXML
    private TableColumn<student, String> colfaculty;

    @FXML
    private TableColumn<student, String> colgender;

    @FXML
    private TableColumn<student, String> colid;

    @FXML
    private TableColumn<student, String> codDob;







    @FXML
    void registerStudent(ActionEvent event) throws SQLException, ClassNotFoundException {
        student studentobj=new student();
        studentobj.setName(txtname.getText());
        studentobj.setAddress(comboaddress.getValue());
        studentobj.setBatchcode(combobatch.getValue());
        studentobj.setDob(txtdob.getText());
        studentobj.setPhone(txtphone.getText());
        studentobj.setEmail(txtemail.getText());
        studentobj.setEnrollnum(txtenroll.getText());
        studentobj.setGender(combogender.getValue());

        studentdao studentdaoobj=new studentdao();
        studentdaoobj.createstudent(studentobj);







    }
    public void show()
    {
        student obj=studentTable.getSelectionModel().getSelectedItem();
       if(obj!=null)
       {
           txtname.setText(obj.getName());
           comboaddress.setValue(obj.getAddress());
           txtphone.setText(obj.getPhone());
           txtemail.setText(obj.getEmail());
           combobatch.setValue(obj.getBatchcode());
           combogender.setValue(obj.getGender());
           txtenroll.setText(obj.getEnrollnum());
           txtdob.setText(obj.getDob());
       }

    }

    @FXML
    void showclicked(MouseEvent event)
    {
        show();


    }

    @FXML
    void update(ActionEvent event) throws SQLException, ClassNotFoundException {
        student studentobj=new student();
        studentobj.setName(txtname.getText());
        studentobj.setAddress(comboaddress.getValue());
        studentobj.setBatchcode(combobatch.getValue());
        studentobj.setDob(txtdob.getText());
        studentobj.setPhone(txtphone.getText());
        studentobj.setEmail(txtemail.getText());
        studentobj.setEnrollnum(txtenroll.getText());
        studentobj.setGender(combogender.getValue());

        studentdao studentdaoobj=new studentdao();
        studentdaoobj.updatestudent(studentobj);


    }

    @FXML
    void delete(ActionEvent event) throws SQLException, ClassNotFoundException {
        student studentobj=new student();
        studentobj.setName(txtname.getText());
        studentobj.setAddress(comboaddress.getValue());
        studentobj.setBatchcode(combobatch.getValue());
        studentobj.setDob(txtdob.getText());
        studentobj.setPhone(txtphone.getText());
        studentobj.setEmail(txtemail.getText());
        studentobj.setEnrollnum(txtenroll.getText());
        studentobj.setGender(combogender.getValue());

        studentdao studentdaoobj=new studentdao();
        studentdaoobj.deletestudent(studentobj);

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        show();


        ObservableList<String>address= FXCollections.observableArrayList("hargeisa","burco","gabilay","wajale");
        comboaddress.setItems(address);


        ObservableList<String>faculty= FXCollections.observableArrayList("ict","accounting","HR","medicne");
        combobatch.setItems(faculty);


        ObservableList<String>gender= FXCollections.observableArrayList("male","female");
        combogender.setItems(gender);

        ///view student table


        ObservableList<student>studentlist= FXCollections.observableArrayList();
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        coladdress.setCellValueFactory(new PropertyValueFactory<>("address"));

        colphone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colemail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colfaculty.setCellValueFactory(new PropertyValueFactory<>("batchcode"));
        colgender.setCellValueFactory(new PropertyValueFactory<>("gender"));

        colid.setCellValueFactory(new PropertyValueFactory<>("enrollnum"));
        codDob.setCellValueFactory(new PropertyValueFactory<>("dob"));

        try {
            Connection co= DBconnection.connect();

            String studentquery = "SELECT * FROM `student`";

            PreparedStatement statement = co.prepareStatement(studentquery);
            ResultSet rs5 = statement.executeQuery();

            while (rs5.next()) {
              studentlist.add(new student(
                     rs5.getString("name"),rs5.getString("address"),rs5.getString("phone"),rs5.getString("email"),rs5.getString("batchcode"),rs5.getString("gender"),rs5.getString("enrolnum"),rs5.getString("dob")
              ));
            }
            studentTable.setItems(studentlist);




        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }




    }
