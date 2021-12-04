package Home.controllers;
import Home.model.Teacher;
import Home.utilities.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import Home.model.subject;
import Home.DAO.subjectDAO;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class subjectController implements Initializable
{

    @FXML
    private TextField txtsubjectname;

    @FXML
    private Button btnsave;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btnndelete;

    @FXML
    private TableView<subject> subjectTable;

    @FXML
    private TableColumn<subject, String> colcode;

    @FXML
    private TableColumn<subject, String> colname;

    @FXML
    private TextField txtcode;

    @FXML
    void delete(ActionEvent event) throws SQLException, ClassNotFoundException {
        subject subjectobj=new subject();
        subjectobj.setSubjectname(txtsubjectname.getText());
        subjectobj.setCode(txtcode.getText());

        subjectDAO subjectDAOobj=new subjectDAO();
        subjectDAOobj.deletesubject(subjectobj);


    }

    @FXML
    void save(ActionEvent event) throws SQLException, ClassNotFoundException {
        subject subjectobj=new subject();
        subjectobj.setSubjectname(txtsubjectname.getText());
        subjectobj.setCode(txtcode.getText());

        subjectDAO subjectDAOobj=new subjectDAO();
        subjectDAOobj.createsubject(subjectobj);



    }

    @FXML
    void showclicked(MouseEvent event)
    {
        subject obj=subjectTable.getSelectionModel().getSelectedItem();
        txtcode.setText(obj.getCode());
        txtsubjectname.setText(obj.getSubjectname());

    }

    @FXML
    void update(ActionEvent event) throws SQLException, ClassNotFoundException {
        subject subjectobj=new subject();
        subjectobj.setSubjectname(txtsubjectname.getText());
        subjectobj.setCode(txtcode.getText());

        subjectDAO subjectDAOobj=new subjectDAO();
        subjectDAOobj.updatesubject(subjectobj);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<subject>list= FXCollections.observableArrayList();
        colname.setCellValueFactory(new PropertyValueFactory<>("subjectname"));
        colcode.setCellValueFactory(new PropertyValueFactory<>("code"));
        try {
            Connection co= DBconnection.connect();
            String query = "SELECT * FROM `subject`";

            PreparedStatement statement = co.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next())
            {
                list.add(new subject(
                        rs.getString("code"), rs.getString("name")


                ));
            }

            } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }


        subjectTable.setItems(list);



    }}
