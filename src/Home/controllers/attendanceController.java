package Home.controllers;

import Home.model.Attendence;
import Home.model.Teacher;
import Home.utilities.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import Home.DAO.*;

public class attendanceController implements Initializable
{
    @FXML
    private TextField txtdate;

    @FXML
    private ComboBox<String> combostudent;

    @FXML
    private ComboBox<String> combosubject;

    @FXML
    private ComboBox<String> combostatus;

    @FXML
    private TableView<Attendence> attendanceTable;

    @FXML
    private TableColumn<Attendence, String> coldate;

    @FXML
    private TableColumn<Attendence, String> coldstudent;

    @FXML
    private TableColumn<Attendence, String> colsubject;

    @FXML
    private TableColumn<Attendence, String> colstatues;

    @FXML
    private Button btnadd;

    @FXML
    private Button btnupdate;

    @FXML
    private Button btndelete;

    @FXML
    void add(ActionEvent event) throws SQLException, ClassNotFoundException {
        Attendence attendenceobj=new Attendence();
        attendenceobj.setDate(txtdate.getText());
        attendenceobj.setStatus(combostatus.getValue());
        attendenceobj.setStudentid(combostudent.getValue());
        attendenceobj.setSubjectid(combosubject.getValue());


        attendencedao attendencedaoobj=new attendencedao();
        attendencedaoobj.createattendance(attendenceobj);

    }

    @FXML
    void delete(ActionEvent event) throws SQLException, ClassNotFoundException {
        Attendence attendenceobj=new Attendence();
        attendenceobj.setDate(txtdate.getText());
        attendenceobj.setStatus(combostatus.getValue());
        attendenceobj.setStudentid(combostudent.getValue());
        attendenceobj.setSubjectid(combosubject.getValue());
        attendencedao attendencedaoobj=new attendencedao();

        attendencedaoobj.deletAttendance(attendenceobj);

    }

    public void show()
    {
        Attendence atobj=attendanceTable.getSelectionModel().getSelectedItem();
        if (atobj!=null)
        {
            txtdate.setText(atobj.getDate());
            combostudent.setValue(atobj.getStudentid());
            combosubject.setValue(atobj.getSubjectid());
            combostatus.setValue(atobj.getStatus());
        }
    }

    @FXML
    void showclicked(MouseEvent event)
    {
        show();

    }

    @FXML
    void update(ActionEvent event) throws SQLException, ClassNotFoundException {
        Attendence attendenceobj=new Attendence();
        attendenceobj.setDate(txtdate.getText());
        attendenceobj.setStatus(combostatus.getValue());
        attendenceobj.setStudentid(combostudent.getValue());
        attendenceobj.setSubjectid(combosubject.getValue());

        attendencedao attendencedaoobj=new attendencedao();
        attendencedaoobj.updateattendance(attendenceobj);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        show();
        Connection co= null;
        try {
            co = DBconnection.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String select="SELECT * FROM `student`";
        PreparedStatement statement1= null;
        try {
            statement1 = co.prepareStatement(select);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet st= null;
        try {
            st = statement1.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ObservableList stid=FXCollections.observableArrayList();
        while (true)
        {
            try {
                if (!st.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                stid.add((st.getString(1)));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        combostudent.setItems(stid);



        ///

        try {
            co = DBconnection.connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String query="SELECT * FROM `subject`";
        PreparedStatement statement= null;
        try {
            statement = co.prepareStatement(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ResultSet rs= null;
        try {
            rs = statement.executeQuery();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        ObservableList s=FXCollections.observableArrayList();
        while (true)
        {
            try {
                if (!rs.next()) break;
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            try {
                s.add((rs.getString(1)));
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }
        combosubject.setItems(s);



        ///


        ObservableList<String>status=FXCollections.observableArrayList("present","upsent");

        combostatus.setItems(status);




//tables view




        ObservableList<Teacher>list= FXCollections.observableArrayList();
        coldate.setCellValueFactory(new PropertyValueFactory<>("date"));
        coldstudent.setCellValueFactory(new PropertyValueFactory<>("studentid"));

        colsubject.setCellValueFactory(new PropertyValueFactory<>("subjectid"));
        colstatues.setCellValueFactory(new PropertyValueFactory<>("status"));
        ObservableList<Attendence>attenlist= FXCollections.observableArrayList();

        try {

            String attenquery = "SELECT * FROM `attendance`";

            PreparedStatement statement3 = co.prepareStatement(attenquery);
            ResultSet rs1 = statement3.executeQuery();

            while (rs1.next()) {
                attenlist.add(new Attendence(rs1.getString("date"), rs1.getString("studentid"), rs1.getString("subjectid"), rs1.getString("statue")));
            }
            attendanceTable.setItems(attenlist);




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    }
