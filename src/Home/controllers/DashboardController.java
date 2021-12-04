package Home.controllers;

import com.mysql.cj.xdevapi.PreparableStatement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import Home.utilities.*;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;


public class DashboardController implements Initializable
{

    @FXML
    private AnchorPane txtusername;

    @FXML
    private Button btnHome;

    @FXML
    private Button btnNotification;

    @FXML
    private Button btnCalendar;

    @FXML
    private Button btnFees;

    @FXML
    private Button btnTechear;

    @FXML
    private Button btnStudent;

    @FXML
    private Button btnBack;

    @FXML
    private Label lbstudentcount;

    @FXML
    private Label lblstudent;



    @FXML
    private Label lblteacher;

    @FXML
    private Label lblsubject;

    @FXML
    private PieChart pichart;

    @FXML
    private LineChart<?, ?> linechart;
    @FXML
    void logout(MouseEvent event) throws IOException {
        url obj=new url();
        obj.show("student registeration", "/Home/view/login.fxml");
        txtusername.getScene().getWindow().hide();


    }

    @FXML
    void btnBack(ActionEvent event) {

    }

    @FXML
    void homeShow(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("student registeration", "/Home/view/dashboard.fxml");

    }

    @FXML
    void showsubject(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("student registeration", "/Home/view/subject.fxml");

    }

    @FXML
    void studentShow(ActionEvent event) throws IOException {
        url obj=new url();
        obj.show("student registeration", "/Home/view/student.fxml");

    }



    @FXML
    void teacherShow(ActionEvent event) throws IOException {
        url url = new url();
        url.show("teacherform","/Home/view/teacher.fxml");

    }

    @FXML
    void showattendance(ActionEvent event) throws IOException {
        url url = new url();
        url.show("teacherform","/Home/view/attendence.fxml");

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        Connection con= null;

        ObservableList<PieChart.Data>data= FXCollections.observableArrayList();
//        data.add(new PieChart.Data("usa",1000));
//        data.add(new PieChart.Data("jpan",500));
//        data.add(new PieChart.Data("china",300));

        pichart.setData(data);
        //pichart.setTitle("Attencence Management System Piechart");


        try {

            con = DBconnection.connect();
            String query="SELECT COUNT(id) FROM student";


            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();

            if (rs.next()){
                String count = rs.getString("count(id)");
                lblstudent.setText(count);



            }

            // teacher






        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }






        try {

            con = DBconnection.connect();
            String query="SELECT COUNT(name) FROM teacher";


            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();

            if (rs.next()){
                String count = rs.getString("count(name)");
                lblteacher.setText(count);



            }








        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {

            con = DBconnection.connect();
            String query="SELECT COUNT(code) FROM subject";


            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();

            if (rs.next()){
                String count = rs.getString("count(code)");
                lblsubject.setText(count);



            }








        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //pichart

        try {

            con = DBconnection.connect();
            String query="SELECT * FROM attendance";


            PreparedStatement statement=con.prepareStatement(query);

            ResultSet rs=statement.executeQuery();

            while (rs.next()){
                data.add(new PieChart.Data(rs.getString("statue"),rs.getInt("studentid")));
            }







        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }










    }
}
