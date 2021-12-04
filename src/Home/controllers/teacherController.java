package Home.controllers;
import Home.model.Teacher;
import Home.DAO.teacherdao;

import Home.utilities.DBconnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class teacherController implements Initializable {
    @FXML
    private TextField txtname;

    @FXML
    private TextField txtaddress;

    @FXML
    private TextField txtgender;

    @FXML
    private TextField txtsubject;
    @FXML
    private TableView<Teacher> teacherTable;

    @FXML
    private TableColumn<Teacher, String> colname;

    @FXML
    private TableColumn<Teacher, String> coladdress;

    @FXML
    private TableColumn<Teacher, String> colgender;

    @FXML
    private TableColumn<Teacher, String> colsubject;

    @FXML
    private Button btnsave;

    @FXML
    private ComboBox<String> combosubject;
    Connection co= DBconnection.connect();

    public teacherController() throws SQLException, ClassNotFoundException {
    }

    @FXML
    void save(ActionEvent event) throws SQLException, ClassNotFoundException {
        Teacher teacherobj = new Teacher();

        teacherobj.setName(txtname.getText());
        teacherobj.setAddress(txtaddress.getText());
        teacherobj.setGender(txtgender.getText());
        teacherobj.setSubject(combosubject.getValue());


        teacherdao teacherdaoobj = new teacherdao();

        teacherdaoobj.createTeacher(teacherobj);

    }


    @FXML
    void delete(ActionEvent event) throws SQLException, ClassNotFoundException {
        Teacher tobj=new Teacher();
        tobj.setName(txtname.getText());
        tobj.setAddress(txtaddress.getText());

        tobj.setGender(txtgender.getText());

        tobj.setSubject(combosubject.getValue());

        teacherdao teacherdaoobj=new teacherdao();
        teacherdaoobj.deleteTeacher(tobj);

    }

    @FXML
    void update(ActionEvent event) throws SQLException, ClassNotFoundException {
        Teacher tobj=new Teacher();
        tobj.setName(txtname.getText());
        tobj.setAddress(txtaddress.getText());

        tobj.setGender(txtgender.getText());

        tobj.setSubject(combosubject.getValue());

        teacherdao teacherdaoobj=new teacherdao();
        teacherdaoobj.updateTeacher(tobj);

    }

    public void show()
    {
        Teacher obj=teacherTable.getSelectionModel().getSelectedItem();
      if (obj!=null)

      {
          txtname.setText(obj.getName());

          txtaddress.setText(obj.getAddress());


          txtgender.setText(obj.getGender());
          combosubject.setValue(obj.getSubject());

      }
    }

    @FXML
    void showcliced(MouseEvent event)
    {
        show();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        show();

        String select="SELECT * FROM `subject`";
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
        combosubject.setItems(stid);





        ObservableList<Teacher>list= FXCollections.observableArrayList();
        colname.setCellValueFactory(new PropertyValueFactory<>("name"));
        colgender.setCellValueFactory(new PropertyValueFactory<>("address"));

        coladdress.setCellValueFactory(new PropertyValueFactory<>("gender"));
        colsubject.setCellValueFactory(new PropertyValueFactory<>("subject"));

        try {

            String query = "SELECT * FROM `teacher`";

            PreparedStatement statement = co.prepareStatement(query);
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                list.add(new Teacher(rs.getString("name"), rs.getString("address"), rs.getString("gender"), rs.getString("subjectid")));
            }
            teacherTable.setItems(list);




    } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

}
